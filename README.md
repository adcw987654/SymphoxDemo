# SymphoxDemo

### Swagger網址
http://localhost:8080/swagger-ui/index.html

### h2管理網址
http://localhost:8080/h2-console/  
相關連線資訊(url、帳密)放在application.yml裡面

### 說明
本專案使用h2資料庫，資料存放於記憶體，故關閉服務會清空db資料  
每次啟用時，會初始化db資訊，並執行src/main/resources/data.sql

請使用java 11編譯
