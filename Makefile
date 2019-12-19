

compile:
	javac -cp .:WEB-INF/lib/* src/*/*.java -d WEB-INF/classes

aaron: compile
	jar -cvf Cinema.war *
	mv *.war ../wildfly-14.0.1.Final/standalone/deployments

kyle: compile
	jar -cvf Cinema.war *
	mv *.war ~/4050/wildfly-14.0.1.Final/standalone/deployments

jonathon: compile
	jar -cvf Cinema.war *
	mv *.war ~/Documents/wildfly-14.0.1.Final/standalone/deployments

james: compile
	jar -cvf Cinema.war *
	mv *.war ../wildfly-14.0.1.Final/standalone/deployments

setup:
	mkdir -p WEB-INF/classes
	mkdir -p WEB-INF/lib
	mkdir -p META-INF
	mkdir -p resources
	cp ../project_files/jboss-servlet-api_4.0_spec-1.0.0.Final.jar WEB-INF/lib/
	cp ../project_files/mysql-connector-java-8.0.13.jar WEB-INF/lib/
	cp ../project_files/freemarker.jar WEB-INF/lib/
	cp ../project_files/activation.jar WEB-INF/lib/
	cp ../project_files/javax.mail.jar WEB-INF/lib/
	cp ../project_files/smtp-1.6.2.jar WEB-INF/lib/

clean:
	rm -rf WEB-INF/classes/*
	rm -f src/*~
	rm -f src/*/*~
	rm -f util/*~
	rm -f other/*~
	rm -f src/*/*#
