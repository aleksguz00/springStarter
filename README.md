# Logging Spring Starter

Стартер для логирования HTTP методов

## Инструкция по сборке проекта

1. Клонировать репозиторий:
   ```bash
   https://github.com/aleksguz00/springStarter.git

2. Перейти в директорию проекта:
   ```bash
    cd

3. Собрать стартер:
   ```bash
   mvn install

4. В своём проекте в pom.xml файле добавить зависимость
   ```bash
   <dependency>
      <groupId>ru.alex</groupId>
      <artifactId>t1-spring-lib</artifactId>
      <version>1.0-SNAPSHOT</version>
    </dependency>
   
5. Создать application.yml файл в своём проекте для конфигурации логирования
   ```bash
   log:
       enabled: true
       level: INFO

6. Собрать проект 
    ```bash
   mvn clean package