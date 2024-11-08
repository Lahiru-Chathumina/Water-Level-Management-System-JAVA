Java Chat Application
This project is a Java-based real-time chat application designed to support multiple participants. The application allows users to exchange messages and images over a network using a graphical interface created with Java Swing.

Features
Real-time Messaging: Supports instant messaging between multiple users.
Image Sharing: Allows participants to send images in the chat.
User-friendly Interface: Built using Java Swing for an intuitive and responsive experience.
Multi-user Support: Enables multiple users to join a chat room simultaneously.
Prerequisites
Java: JDK 8 or higher.
IDE: (Optional) IntelliJ IDEA, Eclipse, or any IDE that supports Java.
Getting Started
Clone the Repository:

bash
Copy code
git clone https://github.com/yourusername/JavaChatApplication.git
cd JavaChatApplication
Compile the Code:

bash
Copy code
javac Main.java
Run the Application:

bash
Copy code
java Main
File Overview
Main.java: Entry point for the application, handles user interface and message handling.
ChatClient.java: Manages the connection and communication for individual clients.
ChatServer.java: Handles server-side connections and message distribution.
ImageHandler.java: Supports image sending functionality.
Usage
Start the server by running ChatServer.
Launch ChatClient on multiple devices or instances to connect with the server.
Use the GUI to send messages and images between participants.
Future Enhancements
User Authentication: Add login functionality to support personalized chat rooms.
File Sharing: Expand to allow other file types beyond images.
Mobile Support: Create an Android-compatible client.
Contributing
Contributions are welcome! Please follow these steps:

Fork the repository.
Create a new branch for your feature.
Submit a pull request.
