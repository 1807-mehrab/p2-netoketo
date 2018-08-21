Drop Table Images;
Drop Table RecipeRatings;
Drop Table Comments;
Drop Table Recipes;
Drop Table Accounts;


CREATE TABLE Accounts(
	AccountID int Primary Key,
	Username VarChar2(50) Unique Not Null,
	Password VarChar2(50) Not Null,
	Email VARCHAR2(50) Not Null,
	AccountType int
);


CREATE TABLE Recipes(
	RecipeID int Primary Key,
	RecipeName varchar2(50) Not Null,
	Deleted int,
	DeletedBy int,
	OwnerID int Not Null,
	Flagged int,
	DateCreated Date,
	Description varchar2(4000) Not NULL,
	Ingredients varchar2(4000) Not NULL,
	CookingInstructions VARCHAR2(4000) Not NULL,
	Foreign Key (DeletedBy) REFERENCES Accounts (AccountID) on delete cascade,
	Foreign Key (OwnerID) REFERENCES Accounts (AccountID) on delete cascade
);


CREATE TABLE Comments(
	CommentID int Primary Key,
	Content VarChar2(1000) Not NULL,
	Flagged int,
	RecipeID int Not NULL,
	OwnerID int Not NULL,
	DateCreated Date,
	FOREIGN KEY (RecipeID) REFERENCES Recipes (RecipeID) on delete cascade,
	FOREIGN KEY (OwnerID) REFERENCES Accounts (AccountID) on delete cascade
);

CREATE TABLE RecipeRatings(
	RatingID int PRIMARY Key,
	OwnerID int Not NULL,
	RecipeID int Not NULL,
	ValNum int,
	DateCreated Date,
	FOREIGN Key (RecipeID) References Recipes (RecipeID) on delete cascade,
	Foreign Key (OwnerID) References Accounts (AccountID) on delete cascade
);

CREATE TABLE Images(
	ImageID int PRIMARY KEY,
	RecipeID int,
	Image BLOB,
	Foreign Key (RecipeID) REFERENCES Recipes (RecipeID) on delete cascade
);