import scala.io.StdIn.readInt
object A2{
    def evaluate(k:Int):Unit={
        if(k<0){
            println("Number is negative");
        }
        else if(k==0){
            println("The number is zero");
        }
        else if(k%2 == 0){
            println("Number is a even number");
        }
        else {
            println("Number is a odd number")
        }
    }

    def main(args: Array[String]):Unit = {
        print("Enter number =");
        val number = readInt();
        evaluate(number);
    }
}