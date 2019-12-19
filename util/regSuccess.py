
import sys
import smtplib

recipient = sys.argv[1]
confirmation_pin = sys.argv[2]

cinemaEmail = "CinemaBookSys@gmail.com"
cinemaPass = "Group11A"

server = smtplib.SMTP('smtp.gmail.com', 587)
server.starttls()
server.login(cinemaEmail, cinemaPass)

msg = "You have successfully registered for the Cinema E-Booking website!\nHere is your confirmation pin: " + confirmation_pin
msg += "\nPlease enter this pin on the confirmation page."
server.sendmail(cinemaEmail, recipient, msg)
server.quit()
