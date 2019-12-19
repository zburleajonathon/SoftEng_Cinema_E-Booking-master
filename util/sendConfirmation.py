import smtplib
import sys
from email.MIMEMultipart import MIMEMultipart
from email.MIMEText import MIMEText

recipient = sys.argv[1]
totalSeats = sys.argv[2]
seatID = sys.argv[3]
price = sys.argv[4]
booking = sys.argv[5]
 
fromaddr = "CinemaBookSys@gmail.com"
toaddr = recipient
msg = MIMEMultipart()
msg['From'] = fromaddr
msg['To'] = toaddr
msg['Subject'] = "Order Confirmation for Order Number " + booking + ""
 
body = "Thank you for booking with Cinema. Your total comes out to $" + price +" and a total of " + totalSeats + " tickets.\n Your seat numbers are: "  + seatID + "."
msg.attach(MIMEText(body, 'plain'))
 
server = smtplib.SMTP('smtp.gmail.com', 587)
server.starttls()
server.login(fromaddr, "Group11A")
text = msg.as_string()
server.sendmail(fromaddr, toaddr, text)
server.quit()
