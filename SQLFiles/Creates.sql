CREATE TABLE Users(
	UserID int Primary Key,
	Username VarChar2(50),
	Password VarChar2(50),
	Email VARCHAR2(50),
	UserType int
);


CREATE TABLE Recipe(
	RecipeID int Primary Key,
	Deleted int,
	DeletedBy int,
	UserID int,
	Flagged int,
	Foreign Key (DeletedBy) REFERENCES Users (UserID) on delete cascade,
	Foreign Key (UserID) REFERENCES Users (UserID) on delete cascade
);


CREATE TABLE Comments(
	CommentID int Primary Key,
	Content VarChar2(300),
	Flagged int,
	RecipeID int,
	UserID int,
	FOREIGN KEY (RecipeID) REFERENCES Recipe (RecipeID) on delete cascade,
	FOREIGN KEY (UserID) REFERENCES Users (UserID) on delete cascade
);

CREATE TABLE RecipeRating(
	RatingID int PRIMARY Key,
	UserID int,
	RecipeID int,
	ValNum int,
	FOREIGN Key (RecipeID) References Recipe (RecipeID) on delete cascade,
	Foreign Key (UserID) References Users (UserID) on delete cascade
);

CREATE TABLE Images(
	ImageID int PRIMARY KEY,
	RecipeID int,
	Image BLOB,
	Foreign Key (RecipeID) REFERENCES Recipe (RecipeID) on delete cascade
);