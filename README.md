# JavaAnimalGarden
Assessment for University of Technology Gdansk - Java.

Task is to create limited area SIZE x SIZE ( 1 < SIZE < 15), easy to define - garden.
There are animals in garden - cats, dogs and turtles.
Each animal has only one owner, one owner can have multiple aminals.

Owner has:
- name
- surname
- sex
- age

Animal has:
- name
- sex
- age
- actual position
- defined owner

Cats and gos has a variable rase (random).
Turtles has a 'status' where they can be ACTIVE or DISACTIVE - hidden in shell or not.

Program shall have a menu with funkctions - f.ex. exit.

There shall be register of owners - with option of remove, add, show all owners with all animals owner has.
There shall be register of animals - with options of remove, add, show all animals.

All details shall be seen.

Program has to have an option to move with those animals on area. They move only one 'square' ahead.
They cannot leave an area. If it tries to leave area there shall be an error, but it shall not stop program.
Turtles can only move in active mode - after they move, then need to be feed (change of status), after they can move again one position.
If we try to move disactive turtle there shall appear an error.

During moving animals we shall receive communication from which position to which position we moved.

After exiting of program, all data shall be saved in files: animals.txt and users.txt.

After running program again, all data shall be loaded from above files. - NOT DONE.
