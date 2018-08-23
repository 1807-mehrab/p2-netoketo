Insert into Accounts (AccountID, Username, Password, Email, AccountType) values (1, 'JOberholtzer', 'p4ssw0rd', 'JObie@netoketo.com', 2);
Insert into Accounts (AccountID, Username, Password, Email, AccountType) values (2, 'KButterfield', 'p4ssw0rd', 'KButte@netoketo.com', 1);
Insert into Accounts (AccountID, Username, Password, Email, AccountType) values (3, 'DMartinez', 'p4ssw0rd', 'DMartinez@netoketo.com', 1);
Insert into Accounts (AccountID, Username, Password, Email, AccountType) values (4, 'TTouch', 'p4ssw0rd', 'TTouch@netoketo.com', 1);
Insert into Accounts (AccountID, Username, Password, Email, AccountType) values (5, 'MBedoya', 'p4ssw0rd', 'MBedoya@netoketo.com', 0);

commit;

Insert into Recipes (RecipeID, RecipeName, Deleted, OwnerID, Flagged, DateCreated, Description, Ingredients, CookingInstructions)
Values (1, 'The Kyle', 0, 2,0, (Select current_timestamp from dual),'The Kyle is a wonderful choice for a simple Keto meal. Can be eaten at lunch or dinner',
'4oz of Burger, 4 Cups of Spinach, 1 Cup of Cheese','Cook the meat and season it with any desired seasoning. Then mix cooked meat with cheese and spinach');

Insert into Recipes (RecipeID, RecipeName, Deleted, OwnerID, Flagged, DateCreated, Description, Ingredients, CookingInstructions)
Values (2, 'The Super Kyle', 0, 2,0, (Select current_timestamp from dual),'The Super Kyle is a wonderful choice for a simple Keto meal. Can be eaten at lunch or dinner. It is approxamtely 140 more calories than a regular Kyle',
'4oz of Burger, 4 Cups of Spinach, 1 Cup of Cheese, 2 Eggs',
'Cook the meat and season it with any desired seasoning. Scramble 2 eggs and season it with any seasoning you desire. Then mix cooked meat with cheese and spinach. Place the eggs on top of the salad.');


Insert into Recipes (RecipeID, RecipeName, Deleted, OwnerID, Flagged, DateCreated, Description, Ingredients, CookingInstructions)
Values (3, 'Keto Quesadillas', 0, 3,0, (Select current_timestamp from dual),'A fun and easy ketogenic quesadilla. Great for lunch and dinner',
'2 eggs, 2 egg whites, 6 oz. cream cheese, 1 1/2 tsp ground psyllium husk powder, 1tbsp coconut flour, 1/2 tsp salt, 5 oz. grated Mexican cheese, 1tbsp olive oil(for frying)',
'1.Preheat the oven to 400°F (200°C).
2. Beat the eggs and egg whites together until fluffy. Add the cream cheese and continue to beat until the batter is smooth.
3.Combine the salt, psyllium husk powder and coconut flour in a small bowl and mix well. Add the flour mixture into the batter while beating. When combined, let the batter sit for a few minutes. It should be thick like pancake batter. Your brand of psyllium husk powder affects this step — be patient… If it does not thicken enough, add some more.
4.Place parchment paper on a baking sheet. Use a spatula to spread the batter over the parchment paper into a big square (if you want round tortillas you can fry them in a frying pan like pancakes).
5.Bake on the upper rack for about 5–7 minutes. The tortilla turns a little brown around the edges when done. Keep your eye on the oven—don’t let these tasty creations burn on the bottom!
6.Cut the big tortilla into smaller pieces (6 pieces per baking sheet).
7.Heat a small, non-stick skillet. Add oil (or butter) if desired. Put a tortilla in the frying pan and sprinkle with cheese, a handful of leafy greens and sprinkle with some more cheese, and top with another tortilla. Fry each quesadilla for about a minute on each side. You’ll know it’s done when the cheese melts.');

Insert into Recipes (RecipeID, RecipeName, Deleted, OwnerID, Flagged, DateCreated, Description, Ingredients, CookingInstructions)
Values (4, 'Keto Pizza', 0, 3, 0, (Select current_timestamp from dual), 'A fun and easy ketogenic personal pizza. Great for lunch and dinner',
'Crust- 4 eggs, 6 oz. shredded cheese(preferably mozerella) Toppings- 3tbsp tomato paste, 1 tsp dried oregano, 5 oz. shredded cheese, 1 1/2 oz. pepperoni, olives Fresh Salad- 5 oz. leafy greens, 4 tbsp olive oil',
'1.A fun and easy ketogenic quesadilla. Great for lunch and dinner
2.Start by making the crust. Crack eggs into a medium-sized bowl and add shredded cheese. Give it a good stir to combine.
3.Use a spatula to spread the cheese and egg batter on a baking sheet lined with parchment paper. You can form two round circles or just make one large rectangular pizza. Bake in the oven for 15 minutes until the pizza crust turns golden. Remove and let cool for a minute or two.
4. Increase the oven temperature to 450°F (225°C).
5. Spread tomato paste on the crust and sprinkle oregano on top. Top with cheese and place the pepperoni and olives on top.
6. Bake for another 5-10 minutes or until the pizza has turned a golden brown color.
7. Serve with a fresh salad on the side.');

Insert into Recipes (RecipeID, RecipeName, Deleted, OwnerID, Flagged, DateCreated, Description, Ingredients, CookingInstructions)
Values (5, 'Keto Chocolate Cake With Peanut ButterCream', 0, 4,0, (Select current_timestamp from dual),'A delicious chocolaty dessert.',
'Chocolate Cake- 1 Cup almound flour, 3/4 cup erythritol, 1/2 cup cocoa powder, 1 1/2 tbsp ground psyllium husk powder, 1 tbsp baking powder, 1/4 tsp salt, 4 eggs, 8oz. cream cheese, 4 oz. salted butter, melted 
Peanut Buttercream Frosting- 8 oz. salad butter, 8 oz. cream cheese, 1/2 cup unsalted and sugar free peanut butter, 1/4 cup powdered erythritol, 2 tsp vanilla extract Decorations- 10 cherries(optional), 1/2 cup heavy whipping cream, 1 tsp chopped salted peanuts',
'1.Position rack in middle of oven and preheat to 350°F (180°C).
2.Combine almond flour, sweetener, cocoa powder (sift to eliminate lumps), ground psyllium husk powder, baking powder and salt in a medium sized bowl. Whisk until thoroughly combined. Set aside.
3. Crack eggs into another big bowl. Beat with electric mixer for a couple of minutes until fluffy. Add cream cheese and melted butter. Continue beating until combined and smooth.
4. Add flour mixture into egg bowl and whisk for a couple of minutes until cake batter is smooth.
5. Grease two 7-inch (18 cm) cake pans — or make one at a time if you only have one pan. Pour half of batter in each cake pan and spread out evenly. Bake in oven for 15–20 minutes or until a toothpick inserted in the middle comes out clean.
6. Allow to cool for at least 10 minutes in pan before transferring to a rack to cool. Wrap layers with plastic wrap and place in the refrigerator; cool completely, preferably overnight.
Peanut ButterCream Frosting
1. Combine room temperatured butter, cream cheese and peanut butter in a bowl. Add sweetener (sift to eliminate lumps) and vanilla extract. Beat with electric mixer until smooth.
Assemble The Cake
1. Place one layer with the flat side up on a plate or cake stand. Cover top with 1/4 of frosting with a spatula or knife. Place second layer on top and spread the rest of the frosting on top and sides of cake.
2. Whip heavy whipping cream until stiff and decorate top with piped rosettes. Put cherries on top—one for each piece of cake. Chop the peanuts and sprinkle them on top.');

Insert into Recipes (RecipeID, RecipeName, Deleted, OwnerID, Flagged, DateCreated, Description, Ingredients, CookingInstructions)
Values (6, 'Keto Asian Cabbage Stir-Fry', 0, 4,0, (Select current_timestamp from dual),'A delicious meal.',
 '25 oz. green cabbage, 5 oz. butter, 20 oz. ground beef, 1 tsp salt, 1 tsp onion powder, 1/4 tsp ground black pepper, 1 tbsp white wine vinegar, 2 garlic cloves, 3 scallions(in slices), 1 tsp chilli flakes 1tbsp fresh ginger(finely chopped or grated), 1 tbsp sesame oil Wasabi Mayonnaise 1 cup Mayonnaise, 1/2 - 1 tbsp wasabi paste',
 '1. Shred the cabbage finely using a sharp knife or a food processor.
 2. Fry the cabbage in 2–3 ounces (60–90 g) butter in a large frying or wok pan on medium-high heat, but dont let the cabbage turn brown. It takes a while for the cabbage to soften.
 3.Add spices and vinegar. Stir and fry for a couple of minutes more. Put the cabbage in a bowl.
 4.Melt the rest of the butter in the same frying pan. Add garlic, chili flakes and ginger and sauté for a few minutes.
 5.Add ground meat and brown until the meat is thoroughly cooked and most of the juices have evaporated. Lower the heat a little.
 6.Add scallions and cabbage to the meat. Stir until everything is hot. Add salt and pepper to taste, and top with the sesame oil before serving.
 7.Mix together the wasabi mayonnaise by starting with a small amount of wasabi and adding more until the flavor is just right. Serve the stir-fry warm with a dollop of wasabi mayonnaise on top.');
 
Insert into Recipes (RecipeID, RecipeName, Deleted, OwnerID, Flagged, DateCreated, Description, Ingredients, CookingInstructions)
Values (7, 'Keto Bacon and Mushroom Breakfast Casserole', 0, 4,0, (Select current_timestamp from dual),'A delicious meal for breakfast.',
'6 oz. mushrooms, 10 oz. bacon, 2 oz. butter, 8 eggs, 1 cup heavy whipping cream, 5 oz. shredded cheddar cheese 1 tsp onion powder, salt and pepper',
'1. Preheat the oven to 400°F (200°C).
2. Trim the mushrooms and cut them in quarters. Dice the bacon.
3. Fry the bacon and mushrooms in butter in a skillet over medium high heat until golden brown. Season with salt and pepper to taste.
4. Place contents the of the skillet in a greased baking dish.
5. Add remaining ingredients to a medium-sized bowl and whisk to combine. Season with salt and pepper.
6. Pour egg mixture over the bacon and mushrooms and bake in the oven for 30-40 minutes or until golden brown on top and set in the middle. Cover with a piece of aluminum foil if the top of the casserole is at risk of burning before its cooked through.');

Insert into Recipes (RecipeID, RecipeName, Deleted, OwnerID, Flagged, DateCreated, Description, Ingredients, CookingInstructions)
Values (8, 'Keto Cheese Roll-ups', 0, 2,0, (Select current_timestamp from dual),'A delicious snack',
'8 oz. cheddar cheese or provolone cheese or edam cheese, in slices, 2 oz butter',
'1.Place the cheese slices on a large cutting board. Slice butter with a cheese slicer or cut really thin pieces with a knife.
2. Cover every cheese slice with butter and roll up. Serve as a snack.');

Insert into Recipes (RecipeID, RecipeName, Deleted, OwnerID, Flagged, DateCreated, Description, Ingredients, CookingInstructions)
Values (9, 'Low Carb Chocolate Mousse', 0, 3,0, (Select current_timestamp from dual),'A delicious snack or dessert',
'27 oz. coconut milk, 3 tbsp cocoa powder, 1 tsp vanilla extract, 1 tsp erythritol (optional)',
'1.Let the coconut milk sit in the fridge for 4 hours or longer to separate the cream from the coconut water.
2. Open the can carefully and scoop out the thick cream with a spoon and put in a bowl. Save the coconut water for a smoothie or pancakes.
3. Whisk the coconut cream, vanilla and optional sweetener with a hand mixer for a couple of minutes until it thickens. Add cocoa powder and whisk some more.
4. Serve in dessert bowls.');

Insert into Recipes (RecipeID, RecipeName, Deleted, OwnerID, Flagged, DateCreated, Description, Ingredients, CookingInstructions)
Values (10, 'Low-Carb Cauliflower Mash', 0, 4,0, (Select current_timestamp from dual),'A must have side for keto meal',
'1 lb cauliflower, 3 oz grated parmesan cheese, 4 oz. butter, 1/2 lemon juice and zest olive oil (optional)',
'1.Cut the cauliflower into florets.
2. Boil the cauliflower in plenty of lightly salted water a couple of minutes – just enough so the florets are tender but retain a somewhat firm texture. Discard the water.
3.Add the cauliflower to a food processor along with the remaining ingredients and pulse until desired consistency. You can also use an immersion blender.
4.Salt and pepper to taste. Add more olive oil or butter if you wish.');

Insert into Recipes (RecipeID, RecipeName, Deleted, DeletedBy,OwnerID, Flagged, DateCreated, Description, Ingredients, CookingInstructions)
Values (11, 'Dark Rye Bread: A European Tradition', 1, 1, 5,0, (Select current_timestamp from dual),'A delicious bread we should alway eat',
'1/2 pint  lukewarm water, 3/4 oz fresh yeast, 2 oz liquid malt extract, 12 oz rye flour, 5 oz all purpose wheat flour, 1/4 oz salt approx. 1/2 tbsp, 5 oz liquid sourdough starter',
'1. Pour the water in a large bowl. Add the yeast and malt extract and stir to dissolve completely.
2. Add the rye flour, wheat flour, salt, and sourdough starter to the liquid mixture. Thoroughly mix everything together.
3. Knead by hand until smooth. Alternatively, knead in a stand mixer fitted with a dough hook for 3 minutes on low speed, then 4 minutes on high speed.
4. Place the dough on a floured countertop and cover with a kitchen towel. Allow to rise for 30 minutes, folding and kneading it every 10 minutes.
5. Gently form the dough into a round loaf and sprinkle with some flour.
6. With a sharp knife, cut a pattern into the surface, such as a cross, grid or square.
7. Put the loaf on a baking sheet, cover with a kitchen towel, and let it rise for another 30 minutes.
8. While the bread is rising, preheat the oven to 425°F/220°C.
9. Once the oven reaches the right temperature, take a spray bottle of water and spray the inside walls of the oven. Keeping the loaf on the baking sheet, transfer it to the hot oven.
10. Bake for 45 minutes, until a dark brown crust forms. Let cool before slicing and eating.');

commit;

Insert into COMMENTS (CommentID, Content, RecipeID, OwnerID, DateCreated) Values (1, 'Wow this is now a staple in my diet.', 1, 1, (Select current_timestamp from dual));
Insert into COMMENTS (CommentID, Content, RecipeID, OwnerID, DateCreated) Values (2, 'If you like this meal check out the Super Kyle.', 1, 2, (Select current_timestamp from dual));
Insert into COMMENTS (CommentID, Content, RecipeID, OwnerID, DateCreated) Values (3, 'Ok I will.', 1, 1, (Select current_timestamp from dual));

Insert into COMMENTS (CommentID, Content, RecipeID, OwnerID, DateCreated) Values (4, 'I love how all the ingredients just go together', 2, 3, (Select current_timestamp from dual));
Insert into COMMENTS (CommentID, Content, RecipeID, OwnerID, DateCreated) Values (5, 'Yes the combination is very tasty', 2, 2, (Select current_timestamp from dual));
Insert into COMMENTS (CommentID, Content, RecipeID, OwnerID, DateCreated) Values (6, 'Thank you so much for sharing this, I can not wait to try it myself', 3, 2, (Select current_timestamp from dual));
Insert into COMMENTS (CommentID, Content, RecipeID, OwnerID, DateCreated) Values (7, 'I love easy keto meals', 4, 4, (Select current_timestamp from dual));
Insert into COMMENTS (CommentID, Content, RecipeID, OwnerID, DateCreated) Values (8, 'I just love pizza and having keto pizza is the best', 4, 2, (Select current_timestamp from dual));
Insert into COMMENTS (CommentID, Content, RecipeID, OwnerID, DateCreated) Values (9, 'This is the best keto pizza imo', 4, 3, (Select current_timestamp from dual));
Insert into COMMENTS (CommentID, Content, RecipeID, OwnerID, DateCreated) Values (10, 'Do you find that when you eat this, that it increases your desire for suger?', 5, 3, (Select current_timestamp from dual));
Insert into COMMENTS (CommentID, Content, RecipeID, OwnerID, DateCreated) Values (11, 'I like asain food and have never had a keto take on it, I think I shall try it.', 6, 2, (Select current_timestamp from dual));
Insert into COMMENTS (CommentID, Content, RecipeID, OwnerID, DateCreated) Values (12, 'Dude Breakfast food is honestly some of my favorite', 7, 2, (Select current_timestamp from dual));
Insert into COMMENTS (CommentID, Content, RecipeID, OwnerID, DateCreated) Values (13, 'This seems simple enough I may actually try it', 8, 3, (Select current_timestamp from dual));
Insert into COMMENTS (CommentID, Content, RecipeID, OwnerID, DateCreated) Values (14, 'You should it is one of my favorite simple snacks', 8, 2, (Select current_timestamp from dual));
Insert into COMMENTS (CommentID, Content, RecipeID, OwnerID, DateCreated) Values (15, 'Do you find that when you eat this, that it increases your desire for suger?', 9, 2, (Select current_timestamp from dual));
Insert into COMMENTS (CommentID, Content, RecipeID, OwnerID, DateCreated) Values (16, 'Not really, this is just a nice little sweet snack', 9, 3, (Select current_timestamp from dual));
Insert into COMMENTS (CommentID, Content, RecipeID, OwnerID, DateCreated) Values (17, 'How close to mashed patatoes does this taste like?', 10, 3, (Select current_timestamp from dual));
Insert into COMMENTS (CommentID, Content, RecipeID, OwnerID, DateCreated) Values (18, 'Well, its cauliflower not potatoes so....', 10, 4, (Select current_timestamp from dual));
Insert into COMMENTS (CommentID, Flagged , Content, RecipeID, OwnerID, DateCreated) Values (19, 1, 'I am flagging this, it is not keto', 11, 2, (Select current_timestamp from dual));
commit;

