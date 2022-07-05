package furhatos.app.socialrobot.flow.main

import furhatos.app.socialrobot.flow.Parent
import furhatos.app.socialrobot.nlu.TalkAboutFeelings
import furhatos.flow.kotlin.*
import furhatos.nlu.common.No
import furhatos.nlu.common.Yes

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
    }
}
