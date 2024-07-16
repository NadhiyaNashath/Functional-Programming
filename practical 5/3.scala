object k3{

    def Fibonacci(n:Int):Unit={
        var array: Array[Int] = Array(0,1);
        print(s"${array(0)} ${array(1)} ")
        for (i <- 2 to n){
            var number:Int = array(i-2)+array(i-1)
            print(s"${number} ");
            array = array :+ number;
        }
    }
    def main(args: Array[String]):Unit = {
        Fibonacci(10);
    }
}