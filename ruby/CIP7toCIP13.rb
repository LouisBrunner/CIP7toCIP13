#!/usr/bin/ruby

module CIP7toCIP13

  def self.compute_checksum num
    str = num.to_s.reverse
    
    even = true
    sum_even = 0
    sum_odd = 0
    str.each_char { |digit|
      val = digit.to_i
      if even
        sum_even += val
      else
        sum_odd += val
      end
      even = !even
    }
    sum = sum_even * 3 + sum_odd
    return 0 unless sum % 10 > 0
    msum = ((sum / 10) + 1) * 10
    return msum - sum
  end

  def self.check_cip13 cip13
    digit = cip13 % 10
    checksum = compute_checksum(cip13 / 10)
    digit == checksum
  end
  
  def self.cip7tocip13 num
    num = ("34009" + num.to_s).to_i
    digit = compute_checksum(num)
    (num.to_s + digit.to_s).to_i
  end
end
