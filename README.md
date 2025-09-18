# 📝 Blog Platform


Blog Platform — это блог-платформа для публикации постов и комментариев.
Пользователи могут создавать и просматривать контент, а также взаимодействовать с ним.
Бэкенд построен на **Spring Boot**, **Spring Security (JWT)** и **JPA**.


---


## ✨ Возможности


- 🔐 **Аутентификация и авторизация**
- JWT (Access токены)
- Access в `Authorization: Bearer ...`


- 👤 **Пользователи**
- Регистрация и вход
- (в планах) профили с именем и аватаром
- Хранение паролей через `BCrypt`


- 📝 **Посты**
- Создание, редактирование и удаление постов
- Просмотр списка и деталей поста


- 💬 **Комментарии**
- Добавление и просмотр комментариев для постов


- 📖 **Документация**
- Swagger UI для тестирования API
- OpenAPI спецификация для интеграций


- ⚡ **Технологии**
- **Java 17+**
- **Spring Boot 3**
- **Spring Security 6 (JWT)**
- **JPA / Hibernate**
- **PostgreSQL**
- **Docker + Docker Compose**
- **Maven**


---


## 🚀 Как пользоваться


1. Склонировать репозиторий и собрать проект:
```bash
mvn clean package -DskipTests
```
2. Запустить через Docker Compose:
```bash
docker-compose up --build
```
3. После запуска:
- API доступно: [http://localhost:8080](http://localhost:9090)
- Swagger UI: [http://localhost:8080/swagger-ui/index.html](http://localhost:9090/swagger-ui/index.html)
- OpenAPI спецификация: [http://localhost:8080/v3/api-docs](http://localhost:9090/v3/api-docs)


4. Для тестирования можно использовать Swagger UI или Postman.


5. Остановка контейнеров:
```bash
docker-compose down
```
