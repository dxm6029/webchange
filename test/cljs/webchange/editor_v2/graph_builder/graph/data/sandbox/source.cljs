(ns webchange.editor-v2.graph-builder.graph.data.sandbox.source)

(def data {:assets        [{:url "/raw/audio/l1/a4/Mari_Level1_Activity4.m4a", :size 5, :type "audio" :alias "mari voice" :target "mari"}
                           {:url "/raw/audio/l1/a4/L1_A4_GameVoice_Set_1.m4a", :size 5, :type "audio" :alias "game voice 1" :target "game-voice"}
                           {:url "/raw/audio/l1/a4/L1_A4_GameVoice_Set_2.m4a", :size 5, :type "audio" :alias "game voice 2" :target "game-voice"}
                           {:url "/raw/audio/l1/a4/L1_A4_GameVoice_Set_3.m4a", :size 5, :type "audio" :alias "game voice 3" :target "game-voice"}

                           {:url "/raw/audio/l1/a4/Mari_L1_A4_Letter_1.m4a", :size 5, :type "audio" :alias "letter 1" :target "mari"}
                           {:url "/raw/audio/l1/a4/Mari_L1_A4_Letter_2.m4a", :size 5, :type "audio" :alias "letter 2" :target "mari"}
                           {:url "/raw/audio/l1/a4/Mari_L1_A4_Letter_3.m4a", :size 5, :type "audio" :alias "letter 3" :target "mari"}

                           {:url "/raw/img/park/sandbox/background.jpg", :size 10 :type "image"}
                           {:url "/raw/img/casa/painting_canvas.png" :type "image"}],
           :objects       {:background {:type "background", :src "/raw/img/park/sandbox/background.jpg"},

                           :mari       {:type    "animation" :scene-name "mari" :name "mari" :anim "idle"
                                        :start   true :speed 0.35
                                        :x       1535 :y 715 :width 473 :height 511
                                        :scale-y 0.5 :scale-x 0.5}

                           :canvas     {:type    "image"
                                        :src     "/raw/img/casa/painting_canvas.png"
                                        :x       1120
                                        :y       500
                                        :width   287
                                        :height  430
                                        :scale-x 1
                                        :scale-y 1}

                           :word       {:type   "transparent" :x 313 :y 91 :width 1200 :height 400
                                        :states {:default {:type "transparent"}
                                                 :show    {:type         "text" :width 1200 :height 400
                                                           :align        "center" :vertical-align "middle"
                                                           :font-family  "Luckiest Guy" :font-size 160
                                                           :shadow-color "#1a1a1a" :shadow-offset {:x 5 :y 5} :shadow-blur 5 :shadow-opacity 0.5
                                                           :fill         "white"}}}

                           :letter     {:type           "text"
                                        :text           ""
                                        :x              1170
                                        :y              540
                                        :width          200
                                        :height         200
                                        :align          "center"
                                        :vertical-align "middle"
                                        :font-family    "Lexend Deca"
                                        :font-size      140
                                        :fill           "#ff8c41"}

                           :box1       {:type       "animation" :x 304 :y 826 :width 771 :height 1033 :anim-offset {:x 0 :y -300}
                                        :name       "boxes" :anim "idle2" :scale {:x 0.25 :y 0.25} :speed 0.3 :loop true :start false
                                        :scene-name "box1" :transition "box1" :skin "qwestion"
                                        :actions    {:click {:type "action" :id "box-1-start" :on "click"}}}

                           :box2       {:type       "animation" :x 401 :y 696 :width 771 :height 1033 :anim-offset {:x 0 :y -300}
                                        :name       "boxes" :anim "idle2" :scale {:x 0.25 :y 0.25} :speed 0.3 :loop true :start false
                                        :scene-name "box2" :transition "box2" :skin "qwestion"
                                        :actions    {:click {:type "action" :id "box-2-start" :on "click"}}}

                           :box3       {:type       "animation" :x 600 :y 674 :width 771 :height 1033 :anim-offset {:x 0 :y -300}
                                        :name       "boxes" :anim "idle2" :scale {:x 0.25 :y 0.25} :speed 0.3 :loop true :start false
                                        :scene-name "box3" :transition "box3" :skin "qwestion"
                                        :actions    {:click {:type "action" :id "box-3-start" :on "click"}}}

                           :box4       {:type       "animation" :x 919 :y 741 :width 771 :height 1033 :anim-offset {:x 0 :y -300}
                                        :name       "boxes" :anim "idle2" :scale {:x 0.25 :y 0.25} :speed 0.3 :loop true :start false
                                        :scene-name "box4" :transition "box4" :skin "qwestion"
                                        :actions    {:click {:type "action" :id "box-4-start" :on "click"}}}

                           },
           :scene-objects [["background"] ["canvas" "box3" "box4" "box2" "box1" "word" "letter"] ["mari"]],
           :actions       {:mari-welcome-audio             {:type               "animation-sequence" :target "mari" :track 1 :offset 0.702
                                                            :audio              "/raw/audio/l1/a4/Mari_Level1_Activity4.m4a" :start 0.702, :duration 5.914
                                                            :data               [{:start 0.775 :end 2.67 :anim "talk"}
                                                                                 {:start 3.189 :end 6.433 :anim "talk"}]
                                                            :phrase             :welcome
                                                            :phrase-description "Welcome"
                                                            :phrase-text        "Welcome to the sandbox! Let’s learn some new words."}

                           :mari-touch-audio               {:type  "animation-sequence" :target "mari" :track 1 :offset 35.155
                                                            :audio "/raw/audio/l1/a4/Mari_Level1_Activity4.m4a", :start 35.155, :duration 3.973
                                                            :data  [{:start 35.31 :end 38.992 :anim "talk"}]}

                           :mari-more-audio                {:type               "animation-sequence" :target "mari" :track 1 :offset 44.997
                                                            :audio              "/raw/audio/l1/a4/Mari_Level1_Activity4.m4a", :start 44.997, :duration 4.337
                                                            :data               [{:start 45.352 :end 46.655 :anim "talk"}
                                                                                 {:start 47.101 :end 49.088 :anim "talk"}]
                                                            :phrase             :more-words
                                                            :phrase-description "More words"
                                                            :phrase-text        "Excellent. Do you want to hear more words?"}

                           :mari-one-more-audio            {:type "parallel"
                                                            :data [{:type "audio", :id "teacher", :start 0.77, :duration 3.24}
                                                                   {:type "sequence-data"
                                                                    :data [{:type "empty" :duration 225}
                                                                           {:type "animation" :target "mari" :id "talk" :track 1}
                                                                           {:type "empty" :duration 1307}
                                                                           {:type "animation" :target "mari" :id "empty" :track 1}
                                                                           {:type "empty" :duration 550}
                                                                           {:type "animation" :target "mari" :id "talk" :track 1}
                                                                           {:type "empty" :duration 1069}
                                                                           {:type "animation" :target "mari" :id "empty" :track 1}]}]}

                           :mari-good-job                  {:type "parallel"
                                                            :data [{:type "audio", :id "teacher", :start 0.77, :duration 3.24}
                                                                   {:type "sequence-data"
                                                                    :data [{:type "empty" :duration 225}
                                                                           {:type "animation" :target "mari" :id "talk" :track 1}
                                                                           {:type "empty" :duration 1307}
                                                                           {:type "animation" :target "mari" :id "empty" :track 1}
                                                                           {:type "empty" :duration 550}
                                                                           {:type "animation" :target "mari" :id "talk" :track 1}
                                                                           {:type "empty" :duration 1069}
                                                                           {:type "animation" :target "mari" :id "empty" :track 1}]}]}

                           :mari-letter-1                  {:type        "animation-sequence",
                                                            :target      "mari",
                                                            :track       1,
                                                            :offset      14.48,
                                                            :audio       "/raw/audio/l1/a4/Mari_Level1_Activity4.m4a",
                                                            :start       14.48,
                                                            :duration    1.746,
                                                            :data        [{:start 14.552, :end 16.159, :duration 1.607, :anim "talk"}]
                                                            :phrase-text "This is the letter"}

                           :mari-letter-2                  {:type        "animation-sequence",
                                                            :target      "mari",
                                                            :track       1,
                                                            :offset      17.239,
                                                            :audio       "/raw/audio/l1/a4/Mari_Level1_Activity4.m4a",
                                                            :start       17.239,
                                                            :duration    1.347,
                                                            :data        [{:start 17.333, :end 18.506, :duration 1.173, :anim "talk"}]
                                                            :phrase-text "Did you know that the letter"}

                           :mari-letter-3                  {:type        "animation-sequence",
                                                            :target      "mari",
                                                            :track       1,
                                                            :offset      19.293,
                                                            :audio       "/raw/audio/l1/a4/Mari_Level1_Activity4.m4a",
                                                            :start       19.293,
                                                            :duration    1.32,
                                                            :data        [{:start 19.413, :end 20.413, :duration 1, :anim "talk"}]
                                                            :phrase-text "makes the sound"}

                           :mari-letter-4                  {:type        "animation-sequence",
                                                            :target      "mari",
                                                            :track       1,
                                                            :offset      23.053,
                                                            :audio       "/raw/audio/l1/a4/Mari_Level1_Activity4.m4a",
                                                            :start       23.053,
                                                            :duration    6.173,
                                                            :data        [{:start 23.133, :end 27.426, :duration 4.293, :anim "talk"}
                                                                          {:start 27.932, :end 29.066, :duration 1.134, :anim "talk"}]
                                                            :phrase-text "Click on the pictures to hear more words that start with the sound"}

                           :mari-short-letter-var          {:type "action" :from-var [{:var-name "current-word" :var-property "sandbox-short-letter-action"}]}
                           :mari-long-letter-var           {:type "action" :from-var [{:var-name "current-word" :var-property "sandbox-long-letter-action"}]}

                           :complete-word-1                {:type "set-variable" :var-name "word-1" :var-value true}
                           :complete-word-2                {:type "set-variable" :var-name "word-2" :var-value true}
                           :complete-word-3                {:type "set-variable" :var-name "word-3" :var-value true}
                           :complete-word-4                {:type "set-variable" :var-name "word-4" :var-value true}

                           :box-1-start-animation          {:type "start-animation" :target "box1"}
                           :box-2-start-animation          {:type "start-animation" :target "box2"}
                           :box-3-start-animation          {:type "start-animation" :target "box3"}
                           :box-4-start-animation          {:type "start-animation" :target "box4"}

                           :box-1-start                    {:type "sequence"
                                                            :data ["complete-word-1"
                                                                   "word-1-state-var"
                                                                   "box-1-start-animation"
                                                                   "box-1-jump-in"
                                                                   "word-1-state-var"
                                                                   "box-1-jump-out"
                                                                   "word-1-state-var"
                                                                   "test-concept-complete"]}

                           :word-1-state-var               {:type               "action" :from-var [{:var-name "current-word" :var-property "sandbox-state-word-1-action"}]
                                                            :phrase             :word-1
                                                            :phrase-description "Pair word 1"}
                           :word-2-state-var               {:type               "action" :from-var [{:var-name "current-word" :var-property "sandbox-state-word-2-action"}]
                                                            :phrase             :word-2
                                                            :phrase-description "Pair word 2"}
                           :word-3-state-var               {:type               "action" :from-var [{:var-name "current-word" :var-property "sandbox-state-word-3-action"}]
                                                            :phrase             :word-3
                                                            :phrase-description "Pair word 3"}
                           :word-4-state-var               {:type               "action" :from-var [{:var-name "current-word" :var-property "sandbox-state-word-4-action"}]
                                                            :phrase             :word-4
                                                            :phrase-description "Pair word 4"}

                           :box-1-jump-in                  {:type "sequence"
                                                            :data ["box-1-jump-in-animation-jump"
                                                                   "box-1-jump-in-empty"
                                                                   "box-1-jump-in-transition"
                                                                   "box-1-jump-in-animation-idle"]}

                           :box-1-jump-in-animation-jump   {:type "animation" :target "box1" :id "jump2"}
                           :box-1-jump-in-empty            {:type "empty" :duration 500}
                           :box-1-jump-in-transition       {:type "transition" :transition-id "box1" :to {:x 668 :y 798 :duration 0.7 :loop false}}
                           :box-1-jump-in-animation-idle   {:type "add-animation" :target "box1" :id "idle2" :loop true}

                           :box-1-jump-out                 {:type "sequence"
                                                            :data ["box-1-jump-out-animation-jump"
                                                                   "box-1-jump-out-empty"
                                                                   "box-1-jump-out-transition"
                                                                   "box-1-jump-out-animation-idle"]}

                           :box-1-jump-out-animation-jump  {:type "animation" :target "box1" :id "jump2"}
                           :box-1-jump-out-empty           {:type "empty" :duration 500}
                           :box-1-jump-out-transition      {:type "transition" :transition-id "box1" :to {:x 304 :y 826 :duration 0.7 :loop false}}
                           :box-1-jump-out-animation-idle  {:type "add-animation" :target "box1" :id "idle2" :loop true}

                           :box-2-start                    {:type "sequence"
                                                            :data ["complete-word-2"
                                                                   "word-2-state-var"
                                                                   "box-2-start-animation"
                                                                   "box-2-jump-in"
                                                                   "word-2-state-var"
                                                                   "box-2-jump-out"
                                                                   "word-2-state-var"
                                                                   "test-concept-complete"]}

                           :box-2-jump-in                  {:type "sequence"
                                                            :data ["box-2-jump-in-animation-jump"
                                                                   "box-2-jump-in-empty"
                                                                   "box-2-jump-in-transition"
                                                                   "box-2-jump-in-animation-idle"]}

                           :box-2-jump-in-animation-jump   {:type "animation" :target "box2" :id "jump2"}
                           :box-2-jump-in-empty            {:type "empty" :duration 500}
                           :box-2-jump-in-transition       {:type "transition" :transition-id "box2" :to {:x 668 :y 798 :duration 0.7 :loop false}}
                           :box-2-jump-in-animation-idle   {:type "add-animation" :target "box2" :id "idle2" :loop true}

                           :box-2-jump-out                 {:type "sequence"
                                                            :data ["box-2-jump-out-animation-jump"
                                                                   "box-2-jump-out-empty"
                                                                   "box-2-jump-out-transition"
                                                                   "box-2-jump-out-animation-idle"]}

                           :box-2-jump-out-animation-jump  {:type "animation" :target "box2" :id "jump2"}
                           :box-2-jump-out-empty           {:type "empty" :duration 500}
                           :box-2-jump-out-transition      {:type "transition" :transition-id "box2" :to {:x 401 :y 696 :duration 0.7 :loop false}}
                           :box-2-jump-out-animation-idle  {:type "add-animation" :target "box2" :id "idle2" :loop true}

                           :box-3-start                    {:type "sequence"
                                                            :data ["complete-word-3"
                                                                   "word-3-state-var"
                                                                   "box-3-start-animation"
                                                                   "box-3-jump-in"
                                                                   "word-3-state-var"
                                                                   "box-3-jump-out"
                                                                   "word-3-state-var"
                                                                   "test-concept-complete"]}

                           :box-3-jump-in                  {:type "sequence"
                                                            :data ["box-3-jump-in-animation-jump"
                                                                   "box-3-jump-in-empty"
                                                                   "box-3-jump-in-transition"
                                                                   "box-3-jump-in-animation-idle"]}

                           :box-3-jump-in-animation-jump   {:type "animation" :target "box3" :id "jump2"}
                           :box-3-jump-in-empty            {:type "empty" :duration 500}
                           :box-3-jump-in-transition       {:type "transition" :transition-id "box3" :to {:x 668 :y 798 :duration 0.7 :loop false}}
                           :box-3-jump-in-animation-idle   {:type "add-animation" :target "box3" :id "idle2" :loop true}

                           :box-3-jump-out                 {:type "sequence"
                                                            :data ["box-3-jump-out-animation-jump"
                                                                   "box-3-jump-out-empty"
                                                                   "box-3-jump-out-transition"
                                                                   "box-3-jump-out-animation-idle"]}

                           :box-3-jump-out-animation-jump  {:type "animation" :target "box3" :id "jump2"}
                           :box-3-jump-out-empty           {:type "empty" :duration 500}
                           :box-3-jump-out-transition      {:type "transition" :transition-id "box3" :to {:x 600 :y 674 :duration 0.7 :loop false}}
                           :box-3-jump-out-animation-idle  {:type "add-animation" :target "box3" :id "idle2" :loop true}

                           :box-4-start                    {:type "sequence"
                                                            :data ["complete-word-4"
                                                                   "word-4-state-var"
                                                                   "box-4-start-animation"
                                                                   "box-4-jump-in"
                                                                   "word-4-state-var"
                                                                   "box-4-jump-out"
                                                                   "word-4-state-var"
                                                                   "test-concept-complete"]}

                           :box-4-jump-in                  {:type "sequence"
                                                            :data ["box-4-jump-in-animation-jump"
                                                                   "box-4-jump-in-empty"
                                                                   "box-4-jump-in-transition"
                                                                   "box-4-jump-in-animation-idle"]}

                           :box-4-jump-in-animation-jump   {:type "animation" :target "box4" :id "jump2"}
                           :box-4-jump-in-empty            {:type "empty" :duration 500}
                           :box-4-jump-in-transition       {:type "transition" :transition-id "box4" :to {:x 668 :y 798 :duration 0.7 :loop false}}
                           :box-4-jump-in-animation-idle   {:type "add-animation" :target "box4" :id "idle2" :loop true}

                           :box-4-jump-out                 {:type "sequence"
                                                            :data ["box-4-jump-out-animation-jump"
                                                                   "box-4-jump-out-empty"
                                                                   "box-4-jump-out-transition"
                                                                   "box-4-jump-out-animation-idle"]}

                           :box-4-jump-out-animation-jump  {:type "animation" :target "box4" :id "jump2"}
                           :box-4-jump-out-empty           {:type "empty" :duration 500}
                           :box-4-jump-out-transition      {:type "transition" :transition-id "box4" :to {:x 919 :y 741 :duration 0.7 :loop false}}
                           :box-4-jump-out-animation-idle  {:type "add-animation" :target "box4" :id "idle2" :loop true}

                           :test-concept-complete          {:type      "test-var-list"
                                                            :var-names ["word-1" "word-2" "word-3" "word-4"]
                                                            :values    [true true true true]
                                                            :success   "next-concept-workflow"}

                           :hide-word                      {:type "state" :target "word" :id "default"}

                           :renew-words                    {:type        "lesson-var-provider"
                                                            :provider-id "words-set"
                                                            :variables   ["item-1" "item-2" "item-3"]
                                                            :shuffled    false
                                                            :from        "concepts"}

                           :renew-current-concept          {:type "parallel"
                                                            :data [{:type "set-variable" :var-name "word-1" :var-value false}
                                                                   {:type "set-variable" :var-name "word-2" :var-value false}
                                                                   {:type "set-variable" :var-name "word-3" :var-value false}
                                                                   {:type "set-variable" :var-name "word-4" :var-value false}
                                                                   {:type        "vars-var-provider"
                                                                    :provider-id "current-word"
                                                                    :variables   ["current-word"]
                                                                    :from        ["item-1" "item-2" "item-3"]
                                                                    :shuffled    false
                                                                    :on-end      "finish-activity"}]}

                           :show-letter                    {:type     "set-attribute" :target "letter" :attr-name "text"
                                                            :from-var [{:var-name        "current-word"
                                                                        :var-property    "letter"
                                                                        :action-property "attr-value"}]}

                           :renew-current-concept-workflow {:type "sequence"
                                                            :data ["renew-current-concept"
                                                                   "box-1-change-skin"
                                                                   "box-2-change-skin"
                                                                   "box-3-change-skin"
                                                                   "box-4-change-skin"
                                                                   "show-letter"
                                                                   "letter-intro"]}

                           :letter-intro                   {:type               "sequence"
                                                            :data               ["mari-letter-1"
                                                                                 "mari-short-letter-var"
                                                                                 "mari-letter-2"
                                                                                 "mari-short-letter-var"
                                                                                 "mari-letter-3"
                                                                                 "mari-long-letter-var"
                                                                                 "mari-letter-4"
                                                                                 "mari-long-letter-var"]
                                                            :phrase             :letter-intro
                                                            :phrase-description "Learn concept sound"}

                           :next-concept-workflow          {:type "sequence"
                                                            :data ["mari-more-audio"
                                                                   "renew-current-concept-workflow"]}

                           :box-1-change-skin              {:type "set-skin" :target "box1" :from-var [{:var-name "current-word" :action-property "skin" :var-property "word-1-skin"}]}
                           :box-2-change-skin              {:type "set-skin" :target "box2" :from-var [{:var-name "current-word" :action-property "skin" :var-property "word-2-skin"}]}
                           :box-3-change-skin              {:type "set-skin" :target "box3" :from-var [{:var-name "current-word" :action-property "skin" :var-property "word-3-skin"}]}
                           :box-4-change-skin              {:type "set-skin" :target "box4" :from-var [{:var-name "current-word" :action-property "skin" :var-property "word-4-skin"}]}

                           :clear-instruction              {:type "remove-flows" :flow-tag "instruction"}
                           :start-scene                    {:type "sequence"
                                                            :data ["start-activity"
                                                                   "clear-instruction"
                                                                   "renew-words"
                                                                   "mari-welcome-audio"
                                                                   "renew-current-concept-workflow"]}

                           :start-activity                 {:type "start-activity" :id "sandbox"}
                           :finish-activity                {:type "finish-activity" :id "sandbox"}}
           :audio         {:mari    "/raw/audio/l1/a4/Mari_Level1_Activity4.m4a"
                           :voice-1 "/raw/audio/l1/a4/L1_A4_GameVoice_Set_1.m4a"
                           :voice-2 "/raw/audio/l1/a4/L1_A4_GameVoice_Set_2.m4a"
                           :voice-3 "/raw/audio/l1/a4/L1_A4_GameVoice_Set_3.m4a"},
           :triggers      {:start {:on "start" :action "start-scene"}}
           :metadata      {:autostart true
                           :prev      "park"}}
  )
