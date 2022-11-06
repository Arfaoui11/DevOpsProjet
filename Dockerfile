FROM nginx:alpine
COPY dist/crud/ /usr/share/nginx/html
COPY nginx.conf /etc/nginx/nginx.conf