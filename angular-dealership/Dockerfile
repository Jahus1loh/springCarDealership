FROM nginx:1.23.3

LABEL build_version=""
LABEL maintainer=""

ENV VERSION="1.0.0-SNAPSHOT"

ENV API_URL http://localhost:8080/api

EXPOSE 80

ADD dist/angular-dealership/browser /usr/share/nginx/html/
