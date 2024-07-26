CREATE TABLE Country (
    id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE Region (
    id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    idCountry INT,
    FOREIGN KEY (idCountry) REFERENCES Country(id)
);

CREATE TABLE City (
    id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    idRegion INT,
    FOREIGN KEY (idRegion) REFERENCES Region(id)
);

CREATE TABLE Gender (
    id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE Person (
    id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    lastname VARCHAR(50) NOT NULL,
    idCity INT,
    address VARCHAR(50) NOT NULL,
    age INT NOT NULL,
    email VARCHAR(100) NOT NULL,
    idGender INT,
    FOREIGN KEY (idCity) REFERENCES City(id),
    FOREIGN KEY (idGender) REFERENCES Gender(id)
);

CREATE TABLE Skill (
    id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE Stack (
    id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE StackSkill (
    idSkill INT,
    idStack INT,
    idStatus INT,
    FOREIGN KEY (idSkill) REFERENCES Skill(id),
    FOREIGN KEY (idStack) REFERENCES Stack(id)
);

CREATE TABLE PersonSkill (
    id INT PRIMARY KEY,
    registrationDate DATE NOT NULL,
    idPerson INT,
    idSkill INT,
    FOREIGN KEY (idPerson) REFERENCES Person(id),
    FOREIGN KEY (idSkill) REFERENCES Skill(id)
);