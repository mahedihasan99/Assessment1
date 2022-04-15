import java.util.*

val scanner: Scanner = Scanner(System.`in`)
val random: Random = Random() //random class generates random numbers
var isGameOn = true
var target = 0
var d1 = 0
var d2 = 0
var sum = 0
var repeat = true

fun main() {
    game()
    while(!isGameOn){
        print("Do you want to Play again? Press Y to continue or Press N to exit: ")
        var value = scanner.nextLine()
        if(value.lowercase() == "y"){
            isGameOn = true
            game()
        }
        else if(value.lowercase() == "n") {
            println("Thanks for playing!")
            break
        }
        else {
            print("Wrong keyword!")
        }
    }
}

fun game(){
    output()
    if(sum == 7 || sum == 11){
        println("You win!")
        isGameOn = false
    }
    else if(sum == 2 || sum == 3 || sum == 12){
        println("You loose!")
        isGameOn = false
    }
    else{
        target = sum
        while(isGameOn){
            print("Hit Enter to roll again:")
            val readEnter = scanner.nextLine()
            if(readEnter.isEmpty()){
                output()
                if(sum == target){
                    println("You Win!")
                    isGameOn = false
                }
                else if(sum == 7){
                    println("You loose!")
                    isGameOn = false
                }
            }
        }
    }
}

fun output(){
    d1 = random.nextInt(6) + 1 //bound 6 means 0-5
    d2 = random.nextInt(6) + 1
    sum = d1 + d2
    println("$d1 $d2 -> ${d1 + d2}")
}
