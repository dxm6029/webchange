(ns webchange.demo-scenes.park.slide)

(def slide-scene
  {:assets        [{:url "/raw/img/park/slide/background.jpg" :type "image"}
                   {:url "/raw/audio/l2/a5/L2_A5_Mari.m4a" :type "audio"}
                   {:url "/raw/audio/l2/a5/L2_A5_Adivinanzas_A_G.m4a" :type "audio"}
                   {:url "/raw/audio/l2/a5/L2_A5_Adivinanzas_G_N.m4a" :type "audio"}
                   {:url "/raw/audio/l2/a5/L2_A5_Adivinanzas_O_end.m4a" :type "audio"}]
   :audio         {:mari "/raw/audio/l2/a5/L2_A5_Mari.m4a"}
   :objects       {:background    {:type "background"
                                   :src  "/raw/img/park/slide/background.jpg"}
                   :mari          {:type       "animation"
                                   :name       "mari"
                                   :transition "mari"
                                   :anim       "idle"
                                   :start      true
                                   :speed      0.35
                                   :x          1600
                                   :y          580
                                   :width      473
                                   :height     511
                                   :scale-y    0.5
                                   :scale-x    0.5}
                   :slide-trigger {:type    "transparent"
                                   :x       580
                                   :y       450
                                   :width   550
                                   :height  500
                                   :actions {:click {:type "action" :id "slide-click" :on "click"}}}
                   :box1          {:type       "animation"
                                   :name       "boxes"
                                   :skin       "qwestion"
                                   :scene-name "box1"
                                   :transition "box1"
                                   :x          710
                                   :y          236
                                   :width      671
                                   :height     633
                                   :scale      {:x 0.18 :y 0.18}
                                   :anim       "idle2"
                                   :speed      0.3
                                   :start      true
                                   :loop       true
                                   :states     {:init-position {:x 710
                                                                :y 236}
                                                :hidden        {:type "transparent"}
                                                :visible       {:type "animation"}}
                                   :actions    {:click {:type "action" :id "pick-box-1" :on "click"}}}
                   :box2          {:type       "animation"
                                   :name       "boxes"
                                   :skin       "qwestion"
                                   :scene-name "box2"
                                   :transition "box2"
                                   :x          500
                                   :y          287
                                   :width      671
                                   :height     633
                                   :scale      {:x 0.18 :y 0.18}
                                   :anim       "idle2"
                                   :speed      0.3
                                   :start      true
                                   :loop       true
                                   :states     {:init-position {:x 500
                                                                :y 287}
                                                :hidden        {:type "transparent"}
                                                :visible       {:type "animation"}}
                                   :actions    {:click {:type "action" :id "pick-box-2" :on "click"}}}
                   :box3          {:type       "animation"
                                   :name       "boxes"
                                   :skin       "qwestion"
                                   :scene-name "box3"
                                   :transition "box3"
                                   :x          595
                                   :y          222
                                   :width      671
                                   :height     633
                                   :scale      {:x 0.18 :y 0.18}
                                   :anim       "idle2"
                                   :speed      0.3
                                   :start      true
                                   :loop       true
                                   :states     {:init-position {:x 595
                                                                :y 222}
                                                :hidden        {:type "transparent"}
                                                :visible       {:type "animation"}}
                                   :actions    {:click {:type "action" :id "pick-box-3" :on "click"}}}}
   :scene-objects [["background"] ["mari"] ["slide-trigger" "box3" "box1" "box2"]]
   :actions       {:start                  {:type "sequence"
                                            :data ["start-activity"
                                                   "clear-instruction"
                                                   "renew-words"
                                                   "mari-voice-welcome"
                                                   "init-state"]}

                   :stop                   {:type "sequence" :data ["stop-activity"]}

                   :start-activity         {:type "start-activity" :id "slide"}

                   :stop-activity          {:type "stop-activity" :id "slide"}

                   :clear-instruction      {:type "remove-flows" :flow-tag "instruction"}

                   :init-state             {:type "parallel"
                                            :data [{:type "set-variable" :var-name "slide-clickable" :var-value true}
                                                   {:type "set-variable" :var-name "answer-clickable" :var-value false}]}

                   :renew-words            {:type        "lesson-var-provider"
                                            :provider-id "words-set"
                                            :variables   ["item-1" "item-2" "item-3"]
                                            :shuffled    true
                                            :from        "concepts"}

                   :renew-current-concept  {:type "sequence-data"
                                            :data [{:type        "vars-var-provider"
                                                    :provider-id "current-concept"
                                                    :variables   ["current-concept"]
                                                    :from        ["item-1" "item-2" "item-3"]
                                                    :shuffled    true
                                                    :on-end      "stop"}
                                                   {:type      "vars-var-provider"
                                                    :variables ["pair-concept-1" "pair-concept-2"]
                                                    :from      ["item-1" "item-2" "item-3"]
                                                    :shuffled  true
                                                    :from-var  [{:var-name "current-concept" :var-property "concept-name"
                                                                 :var-key  "concept-name" :action-property "exclude-property-values"}]}
                                                   {:type      "vars-var-provider"
                                                    :variables ["box1" "box2" "box3"]
                                                    :from      ["current-concept" "pair-concept-1" "pair-concept-2"]
                                                    :shuffled  true}
                                                   {:type "parallel"
                                                    :data [{:type     "set-skin" :target "box1"
                                                            :from-var [{:var-name "box1" :var-property "skin" :action-property "skin"}]}
                                                           {:type     "set-skin" :target "box2"
                                                            :from-var [{:var-name "box2" :var-property "skin" :action-property "skin"}]}
                                                           {:type     "set-skin" :target "box3"
                                                            :from-var [{:var-name "box3" :var-property "skin" :action-property "skin"}]}]}
                                                   {:type     "action"
                                                    :from-var [{:var-name     "current-concept"
                                                                :var-property "riddle"}]}
                                                   {:type "set-variable" :var-name "answer-clickable" :var-value true}]}

                   :reset-boxes            {:type "sequence-data"
                                            :data [{:type "state" :id "hidden" :target "box1"}
                                                   {:type "state" :id "hidden" :target "box2"}
                                                   {:type "state" :id "hidden" :target "box3"}
                                                   {:type "empty" :duration 100}
                                                   {:type "state" :id "init-position" :target "box1"}
                                                   {:type "state" :id "init-position" :target "box2"}
                                                   {:type "state" :id "init-position" :target "box3"}
                                                   {:type "set-skin" :target "box1" :skin "qwestion"}
                                                   {:type "set-skin" :target "box2" :skin "qwestion"}
                                                   {:type "set-skin" :target "box3" :skin "qwestion"}
                                                   {:type "state" :id "visible" :target "box1"}
                                                   {:type "state" :id "visible" :target "box2"}
                                                   {:type "state" :id "visible" :target "box3"}]}

                   :slide-click            {:type     "test-value"
                                            :from-var [{:var-name "slide-clickable" :action-property "value1"}]
                                            :value2   true
                                            :success  {:type "sequence-data"
                                                       :data [{:type "set-variable" :var-name "slide-clickable" :var-value false}
                                                              {:type "action" :id "renew-current-concept"}]}
                                            :fail     {:type "empty" :duration 100}}

                   :pick-box-1             {:type     "test-value"
                                            :from-var [{:var-name "answer-clickable" :action-property "value1"}]
                                            :value2   true
                                            :success  {:type     "test-value"
                                                       :from-var [{:var-name "box1" :action-property "value1"}
                                                                  {:var-name "current-concept" :action-property "value2"}]
                                                       :success  {:type "sequence-data"
                                                                  :data [{:type "set-variable" :var-name "current-target" :var-value "box1"}
                                                                         {:type "action" :id "pick-correct"}]}
                                                       :fail     "pick-wrong"}
                                            :fail     {:type "empty" :duration 100}}


                   :pick-box-2             {:type     "test-value"
                                            :from-var [{:var-name "answer-clickable" :action-property "value1"}]
                                            :value2   true
                                            :success  {:type     "test-value"
                                                       :from-var [{:var-name "box2" :action-property "value1"}
                                                                  {:var-name "current-concept" :action-property "value2"}]
                                                       :success  {:type "sequence-data"
                                                                  :data [{:type "set-variable" :var-name "current-target" :var-value "box2"}
                                                                         {:type "action" :id "pick-correct"}]}
                                                       :fail     "pick-wrong"}
                                            :fail     {:type "empty" :duration 100}}

                   :pick-box-3             {:type     "test-value"
                                            :from-var [{:var-name "answer-clickable" :action-property "value1"}]
                                            :value2   true
                                            :success  {:type     "test-value"
                                                       :from-var [{:var-name "box3" :action-property "value1"}
                                                                  {:var-name "current-concept" :action-property "value2"}]
                                                       :success  {:type "sequence-data"
                                                                  :data [{:type "set-variable" :var-name "current-target" :var-value "box3"}
                                                                         {:type "action" :id "pick-correct"}]}
                                                       :fail     "pick-wrong"}
                                            :fail     {:type "empty" :duration 100}}

                   :pick-correct           {:type "sequence-data"
                                            :data [{:type "set-variable" :var-name "answer-clickable" :var-value false}
                                                   {:type "parallel"
                                                    :data [{:type "action" :id "mari-voice-correct"}
                                                           {:type "sequence-data"
                                                            :data [{:type "empty" :duration 2500}
                                                                   {:type "action" :id "slide-current-target"}]}]}
                                                   {:type "action" :id "mari-voice-try-another"}
                                                   {:type "action" :id "reset-boxes"}
                                                   {:type "set-variable" :var-name "slide-clickable" :var-value true}]}

                   :pick-wrong             {:type "sequence-data"
                                            :data [{:type "set-variable" :var-name "answer-clickable" :var-value false}
                                                   {:type "action" :id "mari-voice-wrong"}
                                                   {:type "empty" :duration 1000}
                                                   {:type     "action"
                                                    :from-var [{:var-name     "current-concept"
                                                                :var-property "riddle"}]}
                                                   {:type "set-variable" :var-name "answer-clickable" :var-value true}]}

                   :slide-current-target   {:type "sequence-data"
                                            :data [{:type     "transition"
                                                    :from-var [{:var-name        "current-target"
                                                                :action-property "transition-id"}]
                                                    :to       {:bezier [{:x 770 :y 90} {:x 865 :y 460}]
                                                               :ease   [0.1 0.1] :duration 1.0}}
                                                   {:type     "transition"
                                                    :from-var [{:var-name        "current-target"
                                                                :action-property "transition-id"}]
                                                    :to       {:bezier [{:x 930 :y 560} {:x 795 :y 775} {:x 975 :y 920}]
                                                               :ease   [0.1 0.1] :duration 1.5}}
                                                   {:type "empty" :duration 1000}]}
                   :reset-current-target   {:type "sequence-data"
                                            :data [{:type "state" :id "hidden" :from-var [{:var-name "current-target" :action-property "target"}]}
                                                   {:type "empty" :duration 100}
                                                   {:type "state" :id "init-position" :from-var [{:var-name "current-target" :action-property "target"}]}
                                                   {:type "empty" :duration 100}
                                                   {:type "state" :id "visible" :from-var [{:var-name "current-target" :action-property "target"}]}]}

                   :mari-voice-welcome     {:type        "parallel"
                                            :description "Como estas pequeno genio? Estas listo para seguir con tu proxima actividad?
                                                            Primero, vamos a empezar por escuchar atentamente la adivinanza.
                                                            Despues, toca la foto para contestarla! Estas listo para empezar? Toca la flecha!"
                                            :data        [{:type "audio" :id "mari" :start 0.974 :duration 25.399}
                                                          {:type "animation-sequence" :target "mari" :track 1 :offset 0.974
                                                           :data [{:start 1.704 :end 3.872 :anim "talk"}
                                                                  {:start 4.735 :end 8.275 :anim "talk"}
                                                                  {:start 9.248 :end 15.620 :anim "talk"}
                                                                  {:start 16.505 :end 20.089 :anim "talk"}
                                                                  {:start 21.151 :end 23.342 :anim "talk"}
                                                                  {:start 24.426 :end 25.643 :anim "talk"}]}]}

                   :mari-voice-correct     {:type        "parallel"
                                            :description "Eso es correcto. Ya lo tienes! Wiiii!"
                                            :data        [{:type "audio" :id "mari" :start 34.714 :duration 5.089}
                                                          {:type "animation-sequence" :target "mari" :track 1 :offset 34.714
                                                           :data [{:start 35.190 :end 38.088 :anim "talk"}
                                                                  {:start 38.508 :end 39.504 :anim "talk"}]}]}

                   :mari-voice-wrong       {:type        "parallel"
                                            :description "No, intenta de nuevo."
                                            :data        [{:type "audio" :id "mari" :start 29.581 :duration 3.120}
                                                          {:type "animation-sequence" :target "mari" :track 1 :offset 29.581
                                                           :data [{:start 29.802 :end 30.621 :anim "talk"}
                                                                  {:start 31.019 :end 32.457 :anim "talk"}]}]}

                   :mari-voice-try-another {:type        "parallel"
                                            :description "Vamos a intentar otra adivinanza. Toca la resbaladilla. "
                                            :data        [{:type "audio" :id "mari" :start 43.188 :duration 5.642}
                                                          {:type "animation-sequence" :target "mari" :track 1 :offset 43.188
                                                           :data [{:start 43.409 :end 46.506 :anim "talk"}
                                                                  {:start 47.037 :end 48.653 :anim "talk"}]}]}}
   :triggers      {:start {:on "start" :action "start"}
                   :stop  {:on "back" :action "stop"}}
   :metadata      {:autostart true
                   :prev      "park"}})