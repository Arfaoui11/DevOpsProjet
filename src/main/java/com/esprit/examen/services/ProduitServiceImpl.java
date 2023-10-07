package com.esprit.examen.services;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import javax.activation.DataSource;
import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeUtility;
import javax.transaction.Transactional;

import com.documents4j.api.DocumentType;
import com.documents4j.api.IConverter;
import com.documents4j.job.LocalConverter;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.CategorieProduitRepository;
import com.esprit.examen.repositories.ProduitRepository;
import com.esprit.examen.repositories.StockRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProduitServiceImpl implements IProduitService {

	@Autowired
	ProduitRepository produitRepository;
	@Autowired
	StockRepository stockRepository;
	@Autowired
	CategorieProduitRepository categorieProduitRepository;


	@Override
	public ByteArrayResource convertDocxToPDF() {
	try {
		XWPFDocument document = new XWPFDocument(new FileInputStream("src/main/resources/static/Docx/word.docx"));
		ByteArrayOutputStream pdfOutputStrem = new ByteArrayOutputStream();

		document.write(pdfOutputStrem);

		IConverter converter = LocalConverter.builder().build();
		ByteArrayInputStream inputStream = new ByteArrayInputStream(pdfOutputStrem.toByteArray());
		ByteArrayOutputStream pdfByteArrayOutputStream = new ByteArrayOutputStream();
		converter.convert(inputStream).as(DocumentType.DOCX).to(pdfByteArrayOutputStream).as(DocumentType.PDF).execute();

		byte[] pdfByteArray = pdfByteArrayOutputStream.toByteArray();

		MimeBodyPart attachment = new MimeBodyPart(new InternetHeaders(),pdfByteArray);
		attachment.setHeader("Content-Type","application/pdf");
		attachment.setHeader("Content-Disposition","attachment; filename=\"" + MimeUtility.encodeText("docs","UTF-8","B")+ "\"");

		DataSource dataSource = attachment.getDataHandler().getDataSource();
		converter.kill();
		document.close();
		return new ByteArrayResource((dataSource).getInputStream().readAllBytes());
	}catch (Exception e)
	{
		e.printStackTrace();
		return null;
	}
	}

	@Override
	public void convertDocx() {
	try {
		XWPFDocument document = new XWPFDocument(new FileInputStream("src/main/resources/static/Docx/word.docx"));
		ByteArrayOutputStream pdfOutputStream = new ByteArrayOutputStream();

		document.write(pdfOutputStream);

		IConverter converter = LocalConverter.builder().build();
		ByteArrayInputStream inputStream = new ByteArrayInputStream(pdfOutputStream.toByteArray());
		//converter.convert(inputStream).as(DocumentType.DOCX).to(pdfByteArrayOutputStream).as(DocumentType.PDF).execute();
		converter.convert(inputStream).as(DocumentType.DOCX).to(new FileOutputStream("src/main/resources/static/Docx/doc.pdf")).as(DocumentType.PDF).execute();
		converter.kill();
		document.close();
		pdfOutputStream.close();
		inputStream.close();

	}catch (Exception e)
	{
		e.printStackTrace();
	}
	}

	@Override
	public List<Produit> retrieveAllProduits() {
		List<Produit> produits = produitRepository.findAll();
		for (Produit produit : produits) {
			log.info(" Produit : " + produit);
		}
		return produits;
	}

	@Transactional
	public Produit addProduit(Produit p) {
		produitRepository.save(p);
		return p;
	}

	

	@Override
	public void deleteProduit(Long produitId) {
		produitRepository.deleteById(produitId);
	}

	@Override
	public Produit updateProduit(Produit p) {
		return produitRepository.save(p);
	}

	@Override
	public Produit retrieveProduit(Long produitId) {
		Produit produit = produitRepository.findById(produitId).orElse(null);
		log.info("produit :" + produit);
		return produit;
	}

	@Override
	public void assignProduitToStock(Long idProduit, Long idStock) {
		Produit produit = produitRepository.findById(idProduit).orElse(null);
		Stock stock = stockRepository.findById(idStock).orElse(null);
		assert produit != null;
		produit.setStock(stock);
		produitRepository.save(produit);

	}


}