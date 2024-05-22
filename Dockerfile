FROM alpine:latest

LABEL authors="Hill" name=hderp description="hderp jdk21 base on alpine image"

RUN apk add --no-cache --no-cache openjdk21

CMD ["java","-version"]

ENTRYPOINT ["top", "-b"]