# BC COVID-19 Response Updater

# Motivation
- I realized that if it weren't for watching the news with my family, I would not be receiving any direct updates from the government about COVID-19. I made this program so that I could be more informed about public health orders.
- I want to learn how to do web scraping and automating tasks.

# User Stories
- I want to be notified when the BC government releases a new COVID-19 update
- I want to be notified by text message
- I want the update to provide a link the takes me to the article where I can find more information
- I want this program to run automatically, every day at a specific time

# Technologies
- Java 8
- Emails are sent using JavaMail API 1.6.2 and JavaBeans Activation Framework 1.3.0
- Web scraping using JSoup 1.13.1

# How-to
- The program is written to send emails using a gmail account:
    1. Enter the sender email address and password in the EmailSender class.
    2. The email can only be sent if on the gmail account: (1) two-step verification is turned off and (2) less secure app access is on.
- The receiver can be an email or you can use an SMS gateway (which I'm using) that links to your phone number. For example, I'm using Koodo and that SMS gateway would be "phonenumber@msg.telus.com".
- Specify the time when you want the application to run. I set it to 3 o'clock since most updates happen in the early afternoon.

# Credits
- code for sending the email is based on: https://www.javatpoint.com/example-of-sending-email-using-java-mail-api-through-gmail-server

