package furhatos.app.socialrobot.flow.main

import furhatos.app.socialrobot.flow.Parent
import furhatos.flow.kotlin.*

val Greeting : State = state(Parent) {
    onEntry {
        random(
            { furhat.ask("Hi there") },
            { furhat.ask("Oh hello there") }
        )
    }

    onResponse {
        goto(TalkAboutFeelings)
    }
}