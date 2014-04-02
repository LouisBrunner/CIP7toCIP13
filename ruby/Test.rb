#!/usr/bin/ruby

module Test
  @@num = 1
  @@errors = 0
  
  class AssertionError < RuntimeError
  end
  
  def self.assert &block
    raise AssertionError unless yield
  end
  
  def self.do(func, name, args, res)
        testn = @@num.to_s.rjust(3, '0')
    print "Test #{testn} : #{name}\n"

    if func.kind_of?(Array)
      obj = Kernel.const_get(func[0])
      ret = obj.send(func[1], args)
      fname = func[0] + "." + func[1]
    else
      ret = send(func, args)
      fname = func
    end
    print "Calling  : #{fname}(#{args})\n"
    print "Returns  : #{ret}\n"
        print "Expected : #{res}\n"
    
    passed = true
    begin
      print "Result   : "
      assert { ret == res }
      print "Passed\n"
    rescue AssertionError
      print "Failed\n"
      passed = false
      @@errors += 1
    end
    
    print "\n"
    @@num += 1
    passed
  end

  def self.do_more(func, arr)
    arr.each { |x|
      Test.do(func, x[0], x[1], x[2])
    }
  end
      
  def self.errors
    @@errors
  end
  
  def self.tests
    @@num - 1
  end
  
  def self.ok
    self.errors == 0
    end
  
  def self.sumup
    res = self.ok ? "OK" : "KO"
    "Tests: #{self.tests}; Errors: #{self.errors}; Result: #{res}"
  end
end
