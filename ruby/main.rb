#!/usr/bin/ruby

require_relative 'CIP7toCIP13'
require_relative 'Test'

def main
  func = ["CIP7toCIP13", "cip7tocip13"]
  arr = [
         ["Aspirine upsa", 3358854, 3400933588540],
         ["Aspirine du rhone", 3342480, 3400933424800],
         ["Doliprane 500mg", 3307199, 3400933071998],
        ]
  Test.do_more(func, arr)

  func = ["CIP7toCIP13", "check_cip13"]
  arr = [
         ["Aspirine upsa", 3400933588540, true],
         ["Faux code", 4400933588540, false],
        ]
  Test.do_more(func, arr)
  
  puts Test.sumup
end

main
