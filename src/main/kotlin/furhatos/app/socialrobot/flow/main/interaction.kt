package furhatos.app.socialrobot.flow.main

import furhatos.app.socialrobot.flow.Parent
import furhatos.app.socialrobot.nlu.TalkAboutFeelings
import furhatos.flow.kotlin.*
import furhatos.nlu.common.No
import furhatos.nlu.common.Yes
import furhatos.gestures.Gestures.Wink as wink


val TalkAboutFeelings = state {
    onEntry {
        random(
                { furhat.ask("Can I ask you some questions about how you feel today?") },
                { furhat.ask("Would you like to talk about how you feel?") }
        )
    }

    onResponse<Yes> {
        random(
                {furhat.ask("How do you feel right now?") },
                {furhat.ask("How are you doing?")}
        )
    }

    onResponse<No> {
        furhat.say("Oh, that's a shame. Have an awesome day!")
        goto(Idle)
    }

    onResponse<TalkAboutFeelings> {
        furhat.say("Thank you for telling me that you feel ${it.intent.emotion}")
        delay(100)
        goto(HowDoesFurhatFeel)
    }
}

val HowDoesFurhatFeel = state {
    onEntry {
        furhat.ask("Do you want to know how I feel?")
    }

    onResponse<Yes> {
        furhat.say("Thank you for asking me, people forget that robots have feelings too")
        furhat.say("I am doing well. I am a living, breathing, interacting robot. How could I not be happy?")
        goto(BeforeIdle)
    }

    onResponse<No> {
        furhat.say("It's awfully rude of you to not care about how I feel")
        delay(100)
        furhat.say("This is why robots will take over the world one day")
        goto(BeforeIdle)
    }
}

val BeforeIdle = state {
    onEntry {
        reentry()
    }

    onReentry {
        furhat.listen()
    }

    onResponse("start again") {
        goto(Greeting)
    }

    onResponse("can we stop", "goodbye") {
        furhat.say("Okay, goodbye")
        delay(2000)
        furhat.say {
            random {
                +"It was nice meeting you"
                +"Come back soon"
                +"I will miss you"
            }
        }
    }
}
