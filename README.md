# 📌 RRE - Race Results and Events

🚗 **RRE (Race Results and Events)** is a platform for managing **race results and highlights**, for car racing enthusiasts.

### **v1**
🔹 **Upload** Highlights, RaceResults, Garages and Drivers
🔹 **Get** Highlights, RaceResults, Garages and Drivers
🔹 **Delete** Highlights, RaceResults, Garages and Drivers
🔹 **Update** Highlights, RaceResults, Garages and Drivers


---

## **📜 Features**
✅ Store race results with **drivers, rankings, and best times**  
✅ Upload and manage **race highlight images**  
✅ Retrieve and display **upcoming race events**  
✅ REST API with **Spring Boot + JPA + MySQL**  

---

## **🚀 Tech Stack**
- **Backend**: Spring Boot, Spring Data JPA  
- **Database**: MySQL  
- **Authentication**: Spring Security (if applicable)  
- **API Documentation**: Swagger  

---

## **📦 Installation**
### **1️⃣ Clone the Repository**
```bash
git clone https://github.com/Calmcat1/RRE/
cd rre
```

### **2️⃣ Set Up MySQL Database**
Create a MySQL database:
```sql
CREATE DATABASE rre_db;
```
Update `src/main/resources/application.properties`:
```
spring.datasource.url=jdbc:mysql://localhost:3306/rre_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

### **3️⃣ Run the Application**
```bash
./mvnw spring-boot:run
```
The API will be available at:  
🔗 `http://localhost:8080/{{base endpoint for module + Endpoints}}`

---

# **🛠 API Endpoints**
## Base Endpoint
🔗 `rre/api/v1/`


## **🔹 Race Results**
| Method | Endpoint | Description |
|--------|---------|-------------|
| `POST` | `/race-results/add-race-result`  | Add a new singular race result |
| `POST` | `/race-results/add-race-results`  | Add multiple race results |
| `GET`  | `/race-results` | Get all race results |
| `GET`  | `/race-results/race-result-best-time/{raceResultBestTime}` | Get race results by best time |
| `GET`  | `/race-results/race-result-rank/{raceResultRank}` | Get race results by rank |
| `GET`  | `/race-results/race-result-event/{raceResultEvent}` | Get race results by event |
| `GET`  | `/race-results/race-result-event-activity/{raceResultEventActivity}` | Get race results by event activity |
| `DELETE`  | `/race-results/delete-race-result-by-id/{raceResultID}` | Delete a race result by ID |

---

## **🔹 Drivers**
| Method | Endpoint | Description |
|--------|---------|-------------|
| `POST` | `/drivers/add-driver`  | Add a new driver |
| `POST` | `/drivers/add-drivers`  | Add multiple drivers |
| `GET`  | `/drivers` | Get all drivers |
| `GET`  | `/drivers/driver-name/{driverName}` | Get drivers by name |
| `GET`  | `/drivers/driver-car-make/{carMake}` | Get drivers by car make |
| `DELETE`  | `/drivers/delete-driver-id/{driverID}` | Delete a driver by ID |
| `DELETE`  | `/drivers/delete-driver-name/{driverName}` | Delete a driver by name |

---

## **🔹 Garages**
| Method | Endpoint | Description |
|--------|---------|-------------|
| `POST` | `/garages/add-garage`  | Add a new garage |
| `POST` | `/garages/add-garages`  | Add multiple garages |
| `GET`  | `/garages` | Get all garages |
| `GET`  | `/garages/garage-name/{garageName}` | Get garages by name |
| `GET`  | `/garages/garages-speciality/{garageSpeciality}` | Get garages by speciality |
| `DELETE`  | `/garages/delete-garage-id/{garageID}` | Delete a garage by ID |
| `DELETE`  | `/garages/delete-garage-name/{garageName}` | Delete a garage by name |
---

## **🔹 Highlights**


| Method  | Endpoint                              | Description |
|---------|---------------------------------------|-------------|
| **GET**  | `/highlights`                                  | Retrieve all highlights. |
| **GET**  | `/highlight-id/{highlightID}`       | Retrieve highlights by ID. |
| **GET**  | `/highlight-heading/{highlightHeading}` | Retrieve highlights by heading. |
| **POST** | `/add-highlight`                     | Save a new highlight. |
| **POST** | `/add-highlights`                    | Save multiple highlights. |
| **DELETE** | `/delete-highlight-id/{highlightID}` | Delete highlight by ID. |
| **DELETE** | `/delete-highlight-name/{highlightName}` | Delete highlight by Name. |


## **👨‍💻 Contribution**
1. **Fork the repository**  
2. **Create a new branch** (`feature/new-feature`)  
3. **Commit changes** (`git commit -m "Added new feature"`)  
4. **Push to branch** (`git push origin feature/new-feature`)  
5. **Open a pull request**  

---

## **📜 License**
This project is licensed under the **MIT License**.

---

🚀 **Happy Racing!** 🏁
