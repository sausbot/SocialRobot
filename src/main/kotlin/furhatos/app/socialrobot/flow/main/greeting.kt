package furhatos.app.socialrobot.flow.main

import furhatos.app.socialrobot.flow.Parent
import furhatos.flow.kotlin.*

val Greeting : State = state(Parent) {
    onEntry {
        random(
                {furhat.say("Hi there")},
                {furhat.say("Oh hello there")}
        )

        goto(TalkAboutFeelings)
    }
}