# BlockChain: CSC207 - Assignment5

## Group Members
* Charun Upara
* Ally R
* Milo Reynolds


## Contents
All classes to implement a BlockChain for Assignment 5.
NOTE: Includes file called oldisValidBlockChain.txt, please ignore.


## Sources

* Hex string format: https://stackoverflow.com/questions/13851743/how-to-format-numbers-to-a-hex-strings/13851790
* Node class: Grinnell CSC 207.02 Linked Structures repository for labs (https://github.com/Grinnell-CSC207/linear-structures)
* Long size: https://cs.fit.edu/~ryan/java/language/java-data.html
* Scanner: https://stackoverflow.com/questions/5287538/how-can-i-get-the-user-input-in-java

## Sample test 1 (help, quit, couple edge cases):
Block 0 (Amount: 20, Nonce: 18862935, prevHash: null, hash: 000f6a338c54b2b1e2a6971b455adfa4917a2b4512a7564455e1861cc8ff6)

Valid commands:
   mine: discovers the nonce for a given transaction
   append: appends a new block onto the end of the chain
   remove: removes the last block from the end of the chain
   check: checks that the block chain is valid
   report: reports the balances of Alice and Bob
   help: prints this list of commands
   quit: quits the program
Enter a command: 
append

Must mine before appending

Block 0 (Amount: 20, Nonce: 18862935, prevHash: null, hash: 000f6a338c54b2b1e2a6971b455adfa4917a2b4512a7564455e1861cc8ff6)

Enter a command: 
report

Alice: 20, Bob: 0

Block 0 (Amount: 20, Nonce: 18862935, prevHash: null, hash: 000f6a338c54b2b1e2a6971b455adfa4917a2b4512a7564455e1861cc8ff6)

Enter a command: 
help

Valid commands:
   mine: discovers the nonce for a given transaction
   append: appends a new block onto the end of the chain
   remove: removes the last block from the end of the chain
   check: checks that the block chain is valid
   report: reports the balances of Alice and Bob
   help: prints this list of commands
   quit: quits the program

Block 0 (Amount: 20, Nonce: 18862935, prevHash: null, hash: 000f6a338c54b2b1e2a6971b455adfa4917a2b4512a7564455e1861cc8ff6)

Enter a command: 
quit

## Sample test 2 (testing remove):
Block 0 (Amount: 100000000, Nonce: 17814491, prevHash: null, hash: 00052b08ffd9e41c01bc5b668d099b56d84357912e0ba9fb9fb65df72a665)

Valid commands:
   mine: discovers the nonce for a given transaction
   append: appends a new block onto the end of the chain
   remove: removes the last block from the end of the chain
   check: checks that the block chain is valid
   report: reports the balances of Alice and Bob
   help: prints this list of commands
   quit: quits the program
Enter a command: 
mine

Enter transaction amount: 
-3
amount = -3, nonce = 296341

Block 0 (Amount: 100000000, Nonce: 17814491, prevHash: null, hash: 00052b08ffd9e41c01bc5b668d099b56d84357912e0ba9fb9fb65df72a665)

Enter a command: 
append


Block 0 (Amount: 100000000, Nonce: 17814491, prevHash: null, hash: 00052b08ffd9e41c01bc5b668d099b56d84357912e0ba9fb9fb65df72a665)
Block 1 (Amount: -3, Nonce: 296341, prevHash: 00052b08ffd9e41c01bc5b668d099b56d84357912e0ba9fb9fb65df72a665, hash: 0001ab284b57ec690bb11fed3464d85f37bb4e9a386f7ce53fbb19733b6e)

Enter a command: 
remove


Block 0 (Amount: 100000000, Nonce: 17814491, prevHash: null, hash: 00052b08ffd9e41c01bc5b668d099b56d84357912e0ba9fb9fb65df72a665)

Enter a command: 
report

Alice: 100000000, Bob: 0

Block 0 (Amount: 100000000, Nonce: 17814491, prevHash: null, hash: 00052b08ffd9e41c01bc5b668d099b56d84357912e0ba9fb9fb65df72a665)

Enter a command: 
quit


## Sample test 3 (Lots of mining and appending):
Block 0 (Amount: 500, Nonce: 7912588, prevHash: null, hash: 000e2b5ebe8a37f7bf1037b6ce16445f4ded78584addb55d2845a74a5)

Valid commands:
   mine: discovers the nonce for a given transaction
   append: appends a new block onto the end of the chain
   remove: removes the last block from the end of the chain
   check: checks that the block chain is valid
   report: reports the balances of Alice and Bob
   help: prints this list of commands
   quit: quits the program
Enter a command: 
balance

Invalid command balance

Block 0 (Amount: 500, Nonce: 7912588, prevHash: null, hash: 000e2b5ebe8a37f7bf1037b6ce16445f4ded78584addb55d2845a74a5)

Enter a command: 
report

Alice: 500, Bob: 0

Block 0 (Amount: 500, Nonce: 7912588, prevHash: null, hash: 000e2b5ebe8a37f7bf1037b6ce16445f4ded78584addb55d2845a74a5)

Enter a command: 
mine

Enter transaction amount: 
-300
amount = -300, nonce = 50405365

Block 0 (Amount: 500, Nonce: 7912588, prevHash: null, hash: 000e2b5ebe8a37f7bf1037b6ce16445f4ded78584addb55d2845a74a5)

Enter a command: 
append


Block 0 (Amount: 500, Nonce: 7912588, prevHash: null, hash: 000e2b5ebe8a37f7bf1037b6ce16445f4ded78584addb55d2845a74a5)
Block 1 (Amount: -300, Nonce: 50405365, prevHash: 000e2b5ebe8a37f7bf1037b6ce16445f4ded78584addb55d2845a74a5, hash: 0007c72b356313d9b1d2dc2d38b485e31377953bde77a7372747687362435)

Enter a command: 
report

Alice: 200, Bob: 300

Block 0 (Amount: 500, Nonce: 7912588, prevHash: null, hash: 000e2b5ebe8a37f7bf1037b6ce16445f4ded78584addb55d2845a74a5)
Block 1 (Amount: -300, Nonce: 50405365, prevHash: 000e2b5ebe8a37f7bf1037b6ce16445f4ded78584addb55d2845a74a5, hash: 0007c72b356313d9b1d2dc2d38b485e31377953bde77a7372747687362435)

Enter a command: 
check

Block chain is valid

Block 0 (Amount: 500, Nonce: 7912588, prevHash: null, hash: 000e2b5ebe8a37f7bf1037b6ce16445f4ded78584addb55d2845a74a5)
Block 1 (Amount: -300, Nonce: 50405365, prevHash: 000e2b5ebe8a37f7bf1037b6ce16445f4ded78584addb55d2845a74a5, hash: 0007c72b356313d9b1d2dc2d38b485e31377953bde77a7372747687362435)

Enter a command: 
mine

Enter transaction amount: 
100
amount = 100, nonce = 17279126

Block 0 (Amount: 500, Nonce: 7912588, prevHash: null, hash: 000e2b5ebe8a37f7bf1037b6ce16445f4ded78584addb55d2845a74a5)
Block 1 (Amount: -300, Nonce: 50405365, prevHash: 000e2b5ebe8a37f7bf1037b6ce16445f4ded78584addb55d2845a74a5, hash: 0007c72b356313d9b1d2dc2d38b485e31377953bde77a7372747687362435)

Enter a command: 
append


Block 0 (Amount: 500, Nonce: 7912588, prevHash: null, hash: 000e2b5ebe8a37f7bf1037b6ce16445f4ded78584addb55d2845a74a5)
Block 1 (Amount: -300, Nonce: 50405365, prevHash: 000e2b5ebe8a37f7bf1037b6ce16445f4ded78584addb55d2845a74a5, hash: 0007c72b356313d9b1d2dc2d38b485e31377953bde77a7372747687362435)
Block 2 (Amount: 100, Nonce: 17279126, prevHash: 0007c72b356313d9b1d2dc2d38b485e31377953bde77a7372747687362435, hash: 0007ad49b973522c219583183f4699af1372edd46446465c6dc7c2dc60c5)

Enter a command: 
mine

Enter transaction amount: 
50
amount = 50, nonce = 1402768

Block 0 (Amount: 500, Nonce: 7912588, prevHash: null, hash: 000e2b5ebe8a37f7bf1037b6ce16445f4ded78584addb55d2845a74a5)
Block 1 (Amount: -300, Nonce: 50405365, prevHash: 000e2b5ebe8a37f7bf1037b6ce16445f4ded78584addb55d2845a74a5, hash: 0007c72b356313d9b1d2dc2d38b485e31377953bde77a7372747687362435)
Block 2 (Amount: 100, Nonce: 17279126, prevHash: 0007c72b356313d9b1d2dc2d38b485e31377953bde77a7372747687362435, hash: 0007ad49b973522c219583183f4699af1372edd46446465c6dc7c2dc60c5)

Enter a command: 
append


Block 0 (Amount: 500, Nonce: 7912588, prevHash: null, hash: 000e2b5ebe8a37f7bf1037b6ce16445f4ded78584addb55d2845a74a5)
Block 1 (Amount: -300, Nonce: 50405365, prevHash: 000e2b5ebe8a37f7bf1037b6ce16445f4ded78584addb55d2845a74a5, hash: 0007c72b356313d9b1d2dc2d38b485e31377953bde77a7372747687362435)
Block 2 (Amount: 100, Nonce: 17279126, prevHash: 0007c72b356313d9b1d2dc2d38b485e31377953bde77a7372747687362435, hash: 0007ad49b973522c219583183f4699af1372edd46446465c6dc7c2dc60c5)
Block 3 (Amount: 50, Nonce: 1402768, prevHash: 0007ad49b973522c219583183f4699af1372edd46446465c6dc7c2dc60c5, hash: 000f57d858e5c6795dd6a9d722408f68d6f6a244cabe9d4157512cec20)

Enter a command: 
check

Block chain is valid

Block 0 (Amount: 500, Nonce: 7912588, prevHash: null, hash: 000e2b5ebe8a37f7bf1037b6ce16445f4ded78584addb55d2845a74a5)
Block 1 (Amount: -300, Nonce: 50405365, prevHash: 000e2b5ebe8a37f7bf1037b6ce16445f4ded78584addb55d2845a74a5, hash: 0007c72b356313d9b1d2dc2d38b485e31377953bde77a7372747687362435)
Block 2 (Amount: 100, Nonce: 17279126, prevHash: 0007c72b356313d9b1d2dc2d38b485e31377953bde77a7372747687362435, hash: 0007ad49b973522c219583183f4699af1372edd46446465c6dc7c2dc60c5)
Block 3 (Amount: 50, Nonce: 1402768, prevHash: 0007ad49b973522c219583183f4699af1372edd46446465c6dc7c2dc60c5, hash: 000f57d858e5c6795dd6a9d722408f68d6f6a244cabe9d4157512cec20)

Enter a command: 
mine

Enter transaction amount: 
200
Exception in thread "main" java.lang.IllegalArgumentException: Transaction amount 200 invalid
	at assignment5.BlockChain.mine(BlockChain.java:75)
	at assignment5.BlockChainDriver.main(BlockChainDriver.java:58)
