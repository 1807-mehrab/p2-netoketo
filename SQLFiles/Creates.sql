Drop Table Images;
Drop Table RecipeRating;
Drop Table Comments;
Drop Table Recpies;
Drop Table Accounts;


CREATE TABLE Accounts(
	AccountID int Primary Key,
	Username VarChar2(50),
	Password VarChar2(50),
	Email VARCHAR2(50),
	AccountType int
);


CREATE TABLE Recipes(
	RecipeID int Primary Key,
	RecipeName varchar2(50),
	Deleted int,
	DeletedBy int,
	OwnerID int,
	Flagged int,
	DateCreated date,
	Foreign Key (DeletedBy) REFERENCES Accounts (AccountID) on delete cascade,
	Foreign Key (OwnerID) REFERENCES Accounts (AccountID) on delete cascade
);


CREATE TABLE Comments(
	CommentID int Primary Key,
	Content VarChar2(300),
	Flagged int,
	RecipeID int,
	OwnerID int,
	FOREIGN KEY (RecipeID) REFERENCES Recipes (RecipeID) on delete cascade,
	FOREIGN KEY (OwnerID) REFERENCES Accounts (AccountID) on delete cascade
);

CREATE TABLE RecipeRating(
	RatingID int PRIMARY Key,
	OwnerID int,
	RecipeID int,
	ValNum int,
	DateCreated date,
	FOREIGN Key (RecipeID) References Recipes (RecipeID) on delete cascade,
	Foreign Key (OwnerID) References Accounts (AccountID) on delete cascade
);

CREATE TABLE Images(
	ImageID int PRIMARY KEY,
	RecipeID int,
	Image BLOB,
	Foreign Key (RecipeID) REFERENCES Recipes (RecipeID) on delete cascade
);