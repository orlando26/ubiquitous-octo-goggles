create table APP_HOUSE(
	Hse_Id int not null auto_increment,
    Hse_Name varchar(255),
    Hse_Passcode varchar(255),
    Hse_Owner_id int not null,

    primary key(Hse_Id)
    CONSTRAINT FK_HouseOwner FOREIGN KEY (Hse_Owner_id) REFERENCES APP_USER(Usr_Id)
);

create table APP_USER(
	Usr_Id int not null AUTO_INCREMENT,
    Usr_Name varchar(255) not null,
    Usr_LastName varchar(255) not null,
    Usr_Username varchar(255) not null,
    Usr_Password varchar(255) not null,
    Usr_Hse_id int null,
    Usr_Last_Modified date not null,
    
    primary key(Usr_Id),
	CONSTRAINT FK_UserHouse FOREIGN KEY (Usr_Hse_id) REFERENCES APP_HOUSE(Hse_Id)
);
