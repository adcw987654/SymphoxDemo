# SymphoxDemo

測試目標：  
建立一個Sprint Boot 2的WEB應用  
需至少採用JDK 1.8(含以上) API  
需透過Maven執行專案控管  
需採用Embedded Database   
需採用任一種ORM框架，如：Spring JPA  
需針對Service撰寫單元測試，覆蓋率60%以上  

使用者情境：  
作為一個交易系統，我需要有API可以讓使用者一次新增一筆交易資料，並且需檢查輸入異常，避免錯誤資料進入資料庫。  
驗收條件：  

transaction_id：不可為空，不可重覆  
point_amount：需為不大於10之正整數  
business_time：不可為空，不可大於當前時間  
```javascript
{  
    "transaction_id": "ab93e00b5a96bc1a25b5c4a83305316e",    
    "point_amount": 10,    
    "business_time": "2020-09-22 08:45:07"    
}
```  
新增交易資料的API商務邏輯為新增下列欄位，並寫入資料庫。    
驗收條件：  

process_cost：計算公式為(point_amount)乘上隨機300~500之值  
created_by: 資料處理員，請寫下您的英文名字  
created_time: 資料處理時間，為當前UTC時間  
請定義適當的Index, Constraints  

|Transaction|
|-----------|
|transaction_id|
|point_amount|
|business_time|
|process_cost|
|created_by|
|created_time|


### Swagger網址
http://localhost:8080/swagger-ui/index.html

### h2管理網址
http://localhost:8080/h2-console/  
相關連線資訊(url、帳密)放在application.yml裡面

### 說明
本專案使用h2資料庫，資料存放於記憶體，故關閉服務會清空db資料  
每次啟用時，會初始化db資訊，並執行src/main/resources/data.sql

請使用java 11編譯
