🎵 MelodyHub – Music Streaming Web Application
✨ Overview

MelodyHub is a full-stack music streaming web application built using Spring MVC, JSP/JSTL, and Hibernate ORM.
It brings together a clean UI, smooth navigation, playlist management, audio playback, and secure database operations to deliver a user-friendly and efficient streaming experience.

Designed with a layered architecture and real-world features like file upload, email notifications, and media streaming, MelodyHub demonstrates strong backend engineering and full-stack development skills.

🚀 Features
🎧 Interactive User Experience

JSP/JSTL-powered UI for smooth navigation

Browse songs, create playlists, mark favorites

Integrated audio playback with media streaming

🔧 Robust Backend Architecture

Spring MVC (Controller–Service–DAO pattern)

Form handling, validation, and modular business logic

Clean separation of concerns for easy scaling

🗄️ Database & ORM Integration

Hibernate ORM + MySQL for seamless CRUD

Well-structured entities: Users, Songs, Categories, Playlists, Favorites, Listening History

Automatic schema updates and optimized queries

📤 File Uploads & Email Alerts

Multipart file upload for media files

Automated welcome emails via Jakarta Mail API

🚀 Deployment & Optimization

Deployed on Apache Tomcat

SQL query optimization for faster response times

🛠️ Tech Stack

Frontend: JSP, JSTL, HTML, CSS

Backend: Spring MVC

Database: MySQL + Hibernate ORM

Server: Apache Tomcat

Build Tool: Maven

Email Service: Jakarta Mail API

📁 Project Structure
MelodyHub/
 ├── src/main/java        # Controllers, services, DAO, models  
 ├── src/main/resources   # Hibernate & Spring configs  
 ├── src/main/webapp      # JSPs, static assets, media files  
 ├── pom.xml              # Maven dependencies  
 └── README.md

▶️ Run the Project Locally
1. Clone the Repository
git clone https://github.com/itznarasimha-dev/MelodyHub-MusicStreamingApp.git

2. Import Project

Open in Eclipse / IntelliJ

Import as Maven Project

3. Configure Database

Create MySQL schema: melodyhub

Update DB credentials in Hibernate config

4. Run on Apache Tomcat

Add project to Tomcat

Start the server

Visit:

http://localhost:8080/MelodyHub

🌟 Status

✔ Fully functional
✔ Production-ready backend architecture
✔ Great for showcasing full-stack Java development skills
