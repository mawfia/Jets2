##Jets2

This web application was created on 9 November 2016 by Michael Andrew Williams.

This class calculates amount of change in USD currency after prompting user for item price and money tendered from customer.
The result is a message telling the user exact amount of dollars bills and coins using the largest dollar/coin possible (i.e. $10.00 in change
will result in one $10.00 bill not one $5.00 bill and five one $1.00 bills etc.).

How to Use Application:
----------------------------------------------------------------------------
Program accepts decimal (beyond two digits) and whole, as well as negative and positive numbers.  However, in order for the code to correctly process transactions price and amount tendered should be in true dollar and coin amounts, otherwise user will be prompted to enter in a valid dollar coin amount, or cancel the transaction.  Values entered with greater than 2 decimal places will be truncated to 2.  Responses to prompts can be in lowercase or uppercase and should be with the provided choices "y" of "n".

This class is comprised of four methods: main, requestPrice, moneyTendered, calculateChange, and displayChange.

public static void main(String[] args):
-----------------------------------------------
This methods only function is to call method requestPrice().

public static boolean requestPrice():
-----------------------------------------------
