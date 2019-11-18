SELECT * FROM CoffeeProgramManager.Account;
INSERT INTO CoffeeProgramManager.Account VALUES ('admin','1', 'Nguyen Tu', 1);
INSERT INTO CoffeeProgramManager.Account VALUES ('user','1', 'Luu Minh', 0);

SELECT * FROM CoffeeProgramManager.OrderTable;
INSERT INTO CoffeeProgramManager.OrderTable VALUES ('1','Table 1', 'emty');
INSERT INTO CoffeeProgramManager.OrderTable VALUES ('2','Table 2', 'emty');
INSERT INTO CoffeeProgramManager.OrderTable VALUES ('3','Table 3', 'emty');
INSERT INTO CoffeeProgramManager.OrderTable VALUES ('4','Table 4', 'emty');
INSERT INTO CoffeeProgramManager.OrderTable VALUES ('5','Table 5', 'emty');
INSERT INTO CoffeeProgramManager.OrderTable VALUES ('6','Table 6', 'emty');
INSERT INTO CoffeeProgramManager.OrderTable VALUES ('7','Table 7', 'emty');
INSERT INTO CoffeeProgramManager.OrderTable VALUES ('8','Table 8', 'emty');
INSERT INTO CoffeeProgramManager.OrderTable VALUES ('9','Table 9', 'emty');
INSERT INTO CoffeeProgramManager.OrderTable VALUES ('10','Table 10', 'emty');

SELECT * FROM CoffeeProgramManager.Bill;

SELECT * FROM CoffeeProgramManager.DrinkCategory;
INSERT INTO CoffeeProgramManager.DrinkCategory VALUES (1,'Coffee');
INSERT INTO CoffeeProgramManager.DrinkCategory VALUES (2,'Tea');
INSERT INTO CoffeeProgramManager.DrinkCategory VALUES (3,'Smoothie');

SELECT * FROM CoffeeProgramManager.Drink;
INSERT INTO CoffeeProgramManager.Drink VALUES ('1','Coffee with milk',68000, 1);
INSERT INTO CoffeeProgramManager.Drink VALUES ('2','Coffee mocha', 70000, 1);
INSERT INTO CoffeeProgramManager.Drink VALUES ('3','Cold brew', 67000, 1);
INSERT INTO CoffeeProgramManager.Drink VALUES ('4','Lemon tea', 60000, 2);
INSERT INTO CoffeeProgramManager.Drink VALUES ('5','Green tea', 72000, 2);
INSERT INTO CoffeeProgramManager.Drink VALUES ('6','Matcha latte', 77000, 2);
INSERT INTO CoffeeProgramManager.Drink VALUES ('7','Strawberry', 75000, 3);
INSERT INTO CoffeeProgramManager.Drink VALUES ('8','Banana', 57000, 3);
INSERT INTO CoffeeProgramManager.Drink VALUES ('9','Kiwi', 60000, 3);

INSERT INTO CoffeeProgramManager.Drink VALUES ('10','Kiwi', 60000, 3);

