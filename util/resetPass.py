import sys
import smtplib

recipient = sys.argv[1]
pin = sys.argv[2]
cinemaEmail = "CinemaBookSys@gmail.com"
cinemaPass = "Group11A"

server = smtplib.SMTP('smtp.gmail.com', 587)
server.starttls()
server.login(cinemaEmail, cinemaPass)
msg = """From: From E-Cinema Booking <CinemaBookSys@gmail.com>
To:
Subject: Reset Password

Here is your new password: 
"""
msg = msg + pin
try:
	server.sendmail(cinemaEmail, recipient, msg)
	print("Successfully sent email")
	server.quit()
except:
	print("Error: unable to send email")
