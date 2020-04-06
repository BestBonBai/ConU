JC = javac
JFLAGS = -g

.SUFFIXES: .java .class
.java.class:
				$(JC) $(JFLAGS) $*.java

PROJECT = \
				Accounts.java \
				Client.java \
				Network.java \
				Server.java \
				Transactions.java \
				Driver.java


project: $(PROJECT:.java =.class)
default: project 

#cleanDebug: removeDEBUG.java

clean:
				$(RM) *.class
