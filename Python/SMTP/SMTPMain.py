# provides the functionalities to interact with SMTP servers.
import smtplib

# helps create plain text email messages
from email.mime.text import MIMEText 

# Email content
sender_email = "nishchay.anand63@gmail.com"
receiver_email = "vsakhujaanand@gmail.com"
subject = "Sample Email"
message = "Hi All, Welcome to the World!"

# creates a secure connection to the email server using STARTTLS encryption (recommended).
with smtplib.SMTP_STARTTLS("smtp.example.com", 587) as server:
    server.starttls()
    server.login(sender_email, "your_password")  # Replace with your password (not recommended to store in code)
    server.sendmail(sender_email, receiver_email, message.encode('utf-8'))  # Encode message for proper formatting

print("Email sent successfully!")