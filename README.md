CIP7toCIP13
===========

Transform a CIP 7 number in a CIP 13 one.

Language: Ruby


Usage
=====

Just call the `cip7tocip13` function with your CIP 7 number as argument.

You can also call the `check_cip13` function to check if your CIP 13 number is valid, or directly `compute_checksum` to generate a new checksum.


Example (Ruby)
==============

cip7tocip13
-----------

`num = CIP7toCIP13.cip7tocip13(3358854) # returns 3400933588540`


check_cip13
-----------

`valid = CIP7toCIP13.check_cip13(3400933588540) # returns true`


compute_checksum
----------------

`digit = CIP7toCIP13.compute_checksum(340093358854) # returns 0`


References
==========

http://www.ucdcip.org/telechargements/CIP_Calcul_de_la_cle_ucd.pdf