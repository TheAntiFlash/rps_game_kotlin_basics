
fun main (){

    /**
     * [gameRules] defines which choice wins between player and cpu
     */
    val gameRules =
        mapOf(
            'R' to 'S',
            'P' to 'R',
            'S' to 'P')

    val cpuOptions = listOf('R', 'P', 'S')

    /**
     * index 0 is cpu score, while index 1 is players score in [scoreSystem]
     */
    val scoreSystem = intArrayOf(0,0)
    println("Welcome to Yahya's RPS Game!")
    println("Remember, first to 3 points wins!")

    while (scoreSystem[0] < 3  && scoreSystem[1] < 3){
        println("\nCurrent Score: [${scoreSystem[0]} - ${scoreSystem[1]}] \n")

        /**
         * Getting player Input
         */
        print("Enter your choice [R,P,S]: ")
        val userChoice = readln().first().uppercaseChar()

        /**
         * Validating player input
         */
        if(displayChoice(userChoice) == "Invalid Input")
        {
            println("Invalid Input!! Try Again!")
            continue
        }

        println("\nYou entered ${displayChoice(userChoice)}")

        /**
         * Generating random [cpuChoice]
         */
        val cpuChoice = cpuOptions.random()
        println("CPU chose: ${displayChoice(cpuChoice)}\n")


        /**
         * Calculating who won with [gameRules] and updating [scoreSystem]
         */
        if (gameRules[userChoice] == cpuChoice){
            println("well done! you won 1 point!")
            scoreSystem[0]++
        }
        else if (gameRules[cpuChoice] == userChoice) {
            println("Aw snap! The cpu won this round. Don't lose hope though!")
            scoreSystem[1]++
        }
        else {
            println("Oh, It's a tie!")
        }

    }

    println("\nFinal Score: [${scoreSystem[0]} - ${scoreSystem[1]}] \n")

    if(scoreSystem[0] == 3) {
        println("\nCongratulations, You won!\nSee you again next time!")
    }
    else {
        println("\nAw shucks, You lost!\nTry  again next time!")
    }
}

/**
 * Helping function to display to player
 */
fun displayChoice(choice : Char) : String {
    return when(choice) {
        'R' -> "Rock"
        'P' -> "Paper"
        'S' -> "Scissors"
        else -> {"Invalid Input"}
    }
}

