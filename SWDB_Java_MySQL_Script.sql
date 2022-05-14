DROP TABLE IF EXISTS bountyhunter;
DROP TABLE IF EXISTS forceuser;
DROP TABLE IF EXISTS jedisith;
DROP TABLE IF EXISTS smuggler;
DROP TABLE IF EXISTS blaster;
DROP TABLE IF EXISTS lightsaber;

CREATE TABLE BountyHunter(
	Name VARCHAR(60) NOT NULL,
    Planet VARCHAR(60) NOT NULL,
    Born_Year INT NOT NULL,
    Born_Era VARCHAR(3) NOT NULL,
    
    Contracts_done INT NOT NULL,
    Min_credits_contract INT NOT NULL,
    
    CONSTRAINT PK_BountyHunter PRIMARY KEY(Name)
);

CREATE TABLE ForceUser(
	Name VARCHAR(60) NOT NULL,
    Planet VARCHAR(60) NOT NULL,
    Born_Year INT NOT NULL,
    Born_Era VARCHAR(3) NOT NULL,
    
    Yrs_practice INT NOT NULL,
    Permadeath BOOL NOT NULL,
    
    CONSTRAINT PK_ForceUser PRIMARY KEY(Name)
);

CREATE TABLE JediSith(
	Name VARCHAR(60) NOT NULL,
    Planet VARCHAR(60) NOT NULL,
    Born_Year INT NOT NULL,
    Born_Era VARCHAR(3) NOT NULL,
    
    Yrs_practice INT NOT NULL,
    Permadeath BOOL NOT NULL,
    
    JSType VARCHAR(4) NOT NULL,
    JSRank VARCHAR(15) NOT NULL,
    
    CONSTRAINT PK_JediStih PRIMARY KEY(Name)
);

CREATE TABLE Smuggler(
	Name VARCHAR(60) NOT NULL,
    Planet VARCHAR(60) NOT NULL,
    Born_Year INT NOT NULL,
    Born_Era VARCHAR(3) NOT NULL,
    
    Shipments_nr INT NOT NULL,
    Parsecs_travelled INT NOT NULL,
    
    CONSTRAINT PK_Smuggler PRIMARY KEY(Name)
);

CREATE TABLE Blaster(
	Name VARCHAR(60) NOT NULL,
    BType VARCHAR(60) NOT NULL,
    Shots INT NOT NULL,
    Cooldown DOUBLE NOT NULL,
    
    CONSTRAINT PK_Blaster PRIMARY KEY(Name)
);

CREATE TABLE Lightsaber(
	Color VARCHAR(60) NOT NULL,
    LType VARCHAR(60) NOT NULL,
    Hilt VARCHAR(60) NOT NULL,
    
    CONSTRAINT CPK_Lightsaber PRIMARY KEY(Color,LType,Hilt)
);

INSERT INTO BountyHunter VALUES("Boba Fett", "Kamino", 32, "BBY", 327, 50000);
INSERT INTO BountyHunter VALUES("Jango Fett", "Kamino", 42, "BBY", 500, 45000);
INSERT INTO BountyHunter VALUES("Bossk", "Trandosha", 53, "BBY", 600, 30000);

INSERT INTO ForceUser VALUES("Darg Skye", "Scarif", 3, "ABY", 5, true);
INSERT INTO ForceUser VALUES("Zara Bolban", "Kashyyyk", 10, "BBY", 10, true);
INSERT Into ForceUser VALUES("Ceth Durron", "Coruscant", 60, "BBY", 40, false);

INSERT INTO JediSith VALUES("Anakin Skywalker", "Tatooine", 41, "BBY", 40, false, "Jedi", "JKnight");
INSERT INTO JediSith VALUES("Yoda", "Unknown", 896, "BBY", 890, false, "Jedi", "JGrandMaster");
INSERT INTO JediSith VALUES("Darth Maul", "Dathomir", 54, "BBY", 50, true, "Sith", "SDarth");

INSERT INTO Smuggler VALUES("Han Solo", "Corellia", 32, "BBY", 120, 50000);
INSERT INTO Smuggler VALUES("Lando Calrissian", "Socorro", 43, "BBY", 200, 60000);

INSERT INTO Blaster VALUES("WESTAR-34", "Blaster pistol", 30, 2.5);
INSERT INTO Blaster VALUES("WESTAR-35", "Blaster pistol", 35, 1.5);
INSERT INTO Blaster VALUES("Relby-v10", "Blaster rifle", 20, 7.4);

INSERT INTO Lightsaber VALUES("Red", "Double-bladed", "Consul");
INSERT INTO Lightsaber VALUES("Green", "Single-bladed", "Adept");
INSERT INTO Lightsaber VALUES("Red", "Dual", "Fireband");

