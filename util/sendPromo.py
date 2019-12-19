
import sys
import smtplib

recipient = sys.argv[1]
promoCode = sys.argv[2]
movieName = sys.argv[3]
percentage = sys.argv[4]
expirationDate = sys.argv[5]

cinemaEmail = "CinemaBookSys@gmail.com"
cinemaPass = "Group11A"

server = smtplib.SMTP('smtp.gmail.com', 587)
server.starttls()
server.login(cinemaEmail, cinemaPass)

msg = "Congratulations! You recieved a promotional code for " + movieName + ". Please enter the code '" + promoCode + "' to recieve " + percentage + "% off your purchase. Please redeem before " + expirationDate + "."
server.sendmail(cinemaEmail, recipient, msg)
server.quit()
