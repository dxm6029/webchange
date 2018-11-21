(ns webchange.scene)

(def home-scene
         {:assets
                         [{:url  "/raw/audio/background/POL-daily-special-short.mp3",
                           :size 10,
                           :type "audio"}
                          {:url  "/raw/audio/effects/NFF-fruit-collected.mp3",
                           :size 1,
                           :type "audio"}
                          {:url "/raw/audio/effects/NFF-glitter.mp3", :size 1, :type "audio"}
                          {:url  "/raw/audio/effects/NFF-robo-elastic.mp3",
                           :size 1,
                           :type "audio"}
                          {:url  "/raw/audio/effects/NFF-rusted-thing.mp3",
                           :size 1,
                           :type "audio"}
                          {:url "/raw/audio/effects/NFF-zing.mp3", :size 1, :type "audio"}
                          {:url  "/raw/audio/scripts/intro/teacher.mp3",
                           :size 5,
                           :type "audio"}
                          {:url "/raw/audio/scripts/intro/vera.mp3", :size 5, :type "audio"}
                          {:url  "/raw/audio/scripts/intro/syllables.mp3",
                           :size 2,
                           :type "audio"}
                          {:url "/raw/img/map/background.png", :size 10, :type "image"}
                          {:url "/raw/img/map/casa_01.png", :size 1, :type "image"}
                          {:url "/raw/img/map/casa_02.png", :size 1, :type "image"}
                          {:url "/raw/img/map/feria_01.png", :size 1, :type "image"}
                          {:url "/raw/img/map/feria_02.png", :size 1, :type "image"}
                          {:url "/raw/img/map/feria_03.png", :size 1, :type "image"}
                          {:url "/raw/img/map/feria_locked.png", :size 1, :type "image"}
                          {:url "/raw/img/casa/background.jpg", :size 10}
                          {:url "/raw/img/casa_door.png", :size 1, :type "image"}
                          {:url "/raw/img/chat_bubble_big.png", :size 1, :type "image"}
                          {:url "/raw/img/teacher.png", :size 1, :type "image"}
                          {:url "/raw/img/teacher_two.png", :size 1, :type "image"}
                          {:url "/raw/img/vera.png", :size 1, :type "image"}
                          {:url "/raw/img/vera/10_sprite_test.png", :size 4, :type "image"}
                          {:url "/raw/img/feria/background.png", :size 10, :type "image"}
                          {:url "/raw/img/feria/back.png", :size 1, :type "image"}
                          {:url "/raw/img/feria/back_active.png", :size 1, :type "image"}
                          {:url "/raw/img/feria/wheel.png", :size 2, :type "image"}
                          {:url "/raw/img/ui/back_button_01.png", :size 1, :type "image"}
                          {:url "/raw/img/ui/back_button_02.png", :size 1, :type "image"}
                          {:url "/raw/img/ui/close_button_01.png", :size 1, :type "image"}
                          {:url "/raw/img/ui/close_button_02.png", :size 1, :type "image"}
                          {:url "/raw/img/ui/play_button_01.png", :size 1, :type "image"}
                          {:url "/raw/img/ui/play_button_02.png", :size 1, :type "image"}
                          {:url "/raw/img/ui/reload_button_01.png", :size 1, :type "image"}
                          {:url "/raw/img/ui/reload_button_02.png", :size 1, :type "image"}
                          {:url "/raw/img/ui/settings_button_01.png", :size 1, :type "image"}
                          {:url "/raw/img/ui/settings_button_02.png", :size 1, :type "image"}
                          {:url "/raw/img/ui/star_01.png", :size 1, :type "image"}
                          {:url "/raw/img/ui/star_02.png", :size 1, :type "image"}
                          {:url "/raw/img/ui/star_03.png", :size 1, :type "image"}
                          {:url  "/raw/img/ferris-wheel/words/Grapes.png",
                           :size 1,
                           :type "image"}
                          {:url  "/raw/img/ferris-wheel/words/Spoon.png",
                           :size 1,
                           :type "image"}
                          {:url  "/raw/img/ferris-wheel/words/Fork.png",
                           :size 1,
                           :type "image"}],
          :objects
                         {:background
                          {:type "background", :src "/raw/img/casa/background.jpg"},
                          :vera
                          {:type  "image",
                           :x     1050,
                           :y     400,
                           :src   "/raw/img/vera.png",
                           :layer 10,
                           :scale {:x 1, :y 1}},
                          :senora-vaca
                          {:type    "image",
                           :x       557,
                           :y       177,
                           :src     "/raw/img/teacher.png",
                           :layer   10,
                           :actions {:click {:type "action", :id "intro", :on "click"}}},
                          :door
                          {:type   "transparent",
                           :x      1146,
                           :y      42,
                           :width  732,
                           :height 810,
                           :states
                                   {:default {:type "transparent", :src nil},
                                    :hover   {:type "image", :src "/raw/img/casa_door.png"}},
                           :actions
                                   {:mouseover
                                           {:type "state", :target "door", :id "hover", :on "mouseover"},
                                    :mouseout
                                           {:type "state", :target "door", :id "default", :on "mouseout"},
                                    :click {:type "scene", :scene-id "map", :on "click"}}}},
          :scene-objects [["background" "door"] ["vera" "senora-vaca"]],
          :actions
                         {:show-word-tenedor
                                          {:type "state", :target "wordImage", :id "tenedor"},
                          :show-word-uvas {:type "state", :target "wordImage", :id "uvas"},
                          :vera-audio-3
                                          {:type "audio", :id "vera", :start 7.871, :duration 2.59},
                          :senora-vaca-audio-5
                                          {:type "audio", :id "teacher", :start 17.577, :duration 5.084},
                          :senora-vaca-audio-7
                                          {:type "audio", :id "teacher", :start 29.75, :duration 2.2},
                          :senora-vaca-audio-2
                                          {:type "audio", :id "teacher", :start 4.453, :duration 6.266},
                          :show-word-cuchara
                                          {:type "state", :target "wordImage", :id "cuchara"},
                          :syllable-cu
                                          {:type "parallel",
                                           :data
                                                 [{:type     "audio",
                                                   :name     "syllable",
                                                   :id       "syllables",
                                                   :start    2.507,
                                                   :duration 0.609,
                                                   :offset   0.1}
                                                  {:type     "audio",
                                                   :name     "clap",
                                                   :id       "syllables",
                                                   :start    2.507,
                                                   :duration 0.609,
                                                   :offset   0.1}
                                                  {:type   "animation",
                                                   :name   "clap",
                                                   :target "senoraVaca",
                                                   :id     "clap"}
                                                  {:type   "state",
                                                   :name   "syllable",
                                                   :target "syllable",
                                                   :id     "show",
                                                   :params {:text "cu"}}]},
                          :syllable-te
                                          {:type "parallel",
                                           :data
                                                 [{:type     "audio",
                                                   :name     "syllable-teacher",
                                                   :id       "syllables",
                                                   :start    4.21,
                                                   :duration 0.646,
                                                   :offset   0.1}
                                                  {:type     "audio",
                                                   :name     "clap-teacher",
                                                   :id       "syllables",
                                                   :start    4.21,
                                                   :duration 0.646,
                                                   :offset   0.1}
                                                  {:type   "animation",
                                                   :name   "clap-teacher",
                                                   :target "senoraVaca",
                                                   :id     "clap"}
                                                  {:type     "audio",
                                                   :name     "syllable-vera",
                                                   :id       "syllables",
                                                   :start    7.625,
                                                   :duration 0.552,
                                                   :offset   0.1}
                                                  {:type     "audio",
                                                   :name     "clap-vera",
                                                   :id       "syllables",
                                                   :start    7.625,
                                                   :duration 0.552,
                                                   :offset   0.1}
                                                  {:type   "animation",
                                                   :name   "clap-vera",
                                                   :target "vera",
                                                   :id     "clap"}
                                                  {:type   "state",
                                                   :name   "syllable",
                                                   :target "syllable",
                                                   :id     "show",
                                                   :params {:text "te"}}]},
                          :syllable-ra
                                          {:type "parallel",
                                           :data
                                                 [{:type     "audio",
                                                   :name     "syllable",
                                                   :id       "syllables",
                                                   :start    2.035,
                                                   :duration 0.388,
                                                   :offset   0.1}
                                                  {:type     "audio",
                                                   :name     "clap",
                                                   :id       "syllables",
                                                   :start    2.035,
                                                   :duration 0.388,
                                                   :offset   0.1}
                                                  {:type   "animation",
                                                   :name   "clap",
                                                   :target "senoraVaca",
                                                   :id     "clap"}]},
                          :senora-vaca-audio-4
                                          {:type "audio", :id "teacher", :start 13.478, :duration 3.232},
                          :syllable-dor
                                          {:type "parallel",
                                           :data
                                                 [{:type     "audio",
                                                   :name     "syllable-teacher",
                                                   :id       "syllables",
                                                   :start    5.54,
                                                   :duration 0.561,
                                                   :offset   0.1}
                                                  {:type     "audio",
                                                   :name     "clap-teacher",
                                                   :id       "syllables",
                                                   :start    5.54,
                                                   :duration 0.561,
                                                   :offset   0.1}
                                                  {:type   "animation",
                                                   :name   "clap-teacher",
                                                   :target "senoraVaca",
                                                   :id     "clap"}
                                                  {:type     "audio",
                                                   :name     "syllable-vera",
                                                   :id       "syllables",
                                                   :start    8.798,
                                                   :duration 0.813,
                                                   :offset   0.1}
                                                  {:type     "audio",
                                                   :name     "clap-vera",
                                                   :id       "syllables",
                                                   :start    8.798,
                                                   :duration 0.813,
                                                   :offset   0.1}
                                                  {:type   "animation",
                                                   :name   "clap-vera",
                                                   :target "vera",
                                                   :id     "clap"}
                                                  {:type   "state",
                                                   :name   "syllable",
                                                   :target "syllable",
                                                   :id     "show",
                                                   :params {:text "dor"}}]},
                          :syllable-u
                                          {:type "parallel",
                                           :data
                                                 [{:type     "audio",
                                                   :name     "syllable",
                                                   :id       "syllables",
                                                   :start    0.029,
                                                   :duration 0.7,
                                                   :offset   0.1}
                                                  {:type     "audio",
                                                   :name     "clap",
                                                   :id       "syllables",
                                                   :start    0.029,
                                                   :duration 0.7,
                                                   :offset   0.1}
                                                  {:type   "animation",
                                                   :name   "clap",
                                                   :target "senoraVaca",
                                                   :id     "clap"}
                                                  {:type   "state",
                                                   :name   "syllable",
                                                   :target "syllable",
                                                   :id     "show",
                                                   :params {:text "u"}}]},
                          :group-tenedor
                                          {:type "sequence",
                                           :name "u-vas syllables",
                                           :data
                                                 ["show-word-tenedor"
                                                  "syllable-te"
                                                  "syllable-ne"
                                                  "syllable-dor"
                                                  "empty-1"
                                                  "syllable-te"
                                                  "syllable-ne"
                                                  "syllable-dor2"
                                                  "empty-1"
                                                  "syllable-te"
                                                  "syllable-ne"
                                                  "syllable-dor3"
                                                  "empty-1"
                                                  "hide-word"
                                                  "hide-syllable"]},
                          :group-vera
                                          {:type "sequence",
                                           :name "vera syllables",
                                           :data
                                                 ["syllable-ve"
                                                  "syllable-ra"
                                                  "empty-1"
                                                  "syllable-ve"
                                                  "syllable-ra"
                                                  "empty-1"]},
                          :syllable-ra2
                                          {:type "parallel",
                                           :data
                                                 [{:type     "audio",
                                                   :name     "syllable",
                                                   :id       "syllables",
                                                   :start    3.829,
                                                   :duration 0.362,
                                                   :offset   0.1}
                                                  {:type     "audio",
                                                   :name     "clap",
                                                   :id       "syllables",
                                                   :start    3.829,
                                                   :duration 0.362,
                                                   :offset   0.1}
                                                  {:type   "animation",
                                                   :name   "clap",
                                                   :target "senoraVaca",
                                                   :id     "clap"}
                                                  {:type   "state",
                                                   :name   "syllable",
                                                   :target "syllable",
                                                   :id     "show",
                                                   :params {:text "ra"}}]},
                          :syllable-cha
                                          {:type "parallel",
                                           :data
                                                 [{:type     "audio",
                                                   :name     "syllable",
                                                   :id       "syllables",
                                                   :start    3.178,
                                                   :duration 0.628,
                                                   :offset   0.1}
                                                  {:type     "audio",
                                                   :name     "clap",
                                                   :id       "syllables",
                                                   :start    3.178,
                                                   :duration 0.628,
                                                   :offset   0.1}
                                                  {:type   "animation",
                                                   :name   "clap",
                                                   :target "senoraVaca",
                                                   :id     "clap"}
                                                  {:type   "state",
                                                   :name   "syllable",
                                                   :target "syllable",
                                                   :id     "show",
                                                   :params {:text "cha"}}]},
                          :senora-vaca-audio-6
                                          {:type "audio", :id "teacher", :start 23.09, :duration 1.86},
                          :syllable-ne
                                          {:type "parallel",
                                           :data
                                                 [{:type     "audio",
                                                   :name     "syllable-teacher",
                                                   :id       "syllables",
                                                   :start    4.878,
                                                   :duration 0.653,
                                                   :offset   0.1}
                                                  {:type     "audio",
                                                   :name     "clap-teacher",
                                                   :id       "syllables",
                                                   :start    4.878,
                                                   :duration 0.653,
                                                   :offset   0.1}
                                                  {:type   "animation",
                                                   :name   "clap-teacher",
                                                   :target "senoraVaca",
                                                   :id     "clap"}
                                                  {:type     "audio",
                                                   :name     "syllable-vera",
                                                   :id       "syllables",
                                                   :start    8.211,
                                                   :duration 0.56,
                                                   :offset   0.1}
                                                  {:type     "audio",
                                                   :name     "clap-vera",
                                                   :id       "syllables",
                                                   :start    8.211,
                                                   :duration 0.56,
                                                   :offset   0.1}
                                                  {:type   "animation",
                                                   :name   "clap-vera",
                                                   :target "vera",
                                                   :id     "clap"}
                                                  {:type   "state",
                                                   :name   "syllable",
                                                   :target "syllable",
                                                   :id     "show",
                                                   :params {:text "ne"}}]},
                          :senora-vaca-audio-1
                                          {:type "audio", :id "teacher", :start 0.749, :duration 2.68},
                          :syllable-ve
                                          {:type "parallel",
                                           :data
                                                 [{:type     "audio",
                                                   :name     "syllable",
                                                   :id       "syllables",
                                                   :start    1.383,
                                                   :duration 0.633,
                                                   :offset   0.1}
                                                  {:type     "audio",
                                                   :name     "clap",
                                                   :id       "syllables",
                                                   :start    1.383,
                                                   :duration 0.633,
                                                   :offset   0.1}
                                                  {:type   "animation",
                                                   :name   "clap",
                                                   :target "senoraVaca",
                                                   :id     "clap"}]},
                          :senora-vaca-audio-3
                                          {:type "audio", :id "teacher", :start 11.508, :duration 1.931},
                          :intro
                                          {:type "sequence",
                                           :data
                                                 ["senora-vaca-audio-1"
                                                  "vera-audio-1"
                                                  "senora-vaca-audio-2"
                                                  "vera-audio-2"
                                                  "vera-audio-3"
                                                  "senora-vaca-audio-3"
                                                  "senora-vaca-audio-4"
                                                  "vera-audio-4"
                                                  "senora-vaca-audio-5"
                                                  "senora-vaca-audio-6"
                                                  "group-vera"
                                                  "vera-audio-5"
                                                  "senora-vaca-audio-7"
                                                  "group-uvas"
                                                  "senora-vaca-audio-8"
                                                  "group-cuchara"
                                                  "vera-audio-6"
                                                  "senora-vaca-audio-9"
                                                  "group-tenedor"
                                                  "senora-vaca-audio-10"]},
                          :syllable-dor3
                                          {:type "parallel",
                                           :data
                                                 [{:type     "audio",
                                                   :name     "syllable-teacher",
                                                   :id       "syllables",
                                                   :start    6.743,
                                                   :duration 0.87,
                                                   :offset   0.1}
                                                  {:type     "audio",
                                                   :name     "clap-teacher",
                                                   :id       "syllables",
                                                   :start    6.743,
                                                   :duration 0.87,
                                                   :offset   0.1}
                                                  {:type   "animation",
                                                   :name   "clap-teacher",
                                                   :target "senoraVaca",
                                                   :id     "clap"}
                                                  {:type     "audio",
                                                   :name     "syllable-vera",
                                                   :id       "syllables",
                                                   :start    8.798,
                                                   :duration 0.813,
                                                   :offset   0.1}
                                                  {:type     "audio",
                                                   :name     "clap-vera",
                                                   :id       "syllables",
                                                   :start    8.798,
                                                   :duration 0.813,
                                                   :offset   0.1}
                                                  {:type   "animation",
                                                   :name   "clap-vera",
                                                   :target "vera",
                                                   :id     "clap"}
                                                  {:type   "state",
                                                   :name   "syllable",
                                                   :target "syllable",
                                                   :id     "show",
                                                   :params {:text "dor"}}]},
                          :hide-word      {:type "state", :target "wordImage", :id "default"},
                          :hide-syllable  {:type "state", :target "syllable", :id "default"},
                          :group-uvas
                                          {:type "sequence",
                                           :name "u-vas syllables",
                                           :data
                                                 ["show-word-uvas"
                                                  "syllable-u"
                                                  "syllable-vas"
                                                  "empty-1"
                                                  "syllable-u"
                                                  "syllable-vas"
                                                  "empty-1"
                                                  "syllable-u"
                                                  "syllable-vas"
                                                  "empty-1"
                                                  "hide-word"
                                                  "hide-syllable"]},
                          :vera-audio-1
                                          {:type "audio", :id "vera", :start 1.1, :duration 4.4232},
                          :syllable-vas
                                          {:type "parallel",
                                           :data
                                                 [{:type     "audio",
                                                   :name     "syllable",
                                                   :id       "syllables",
                                                   :start    0.744,
                                                   :duration 0.607,
                                                   :offset   0.1}
                                                  {:type     "audio",
                                                   :name     "clap",
                                                   :id       "syllables",
                                                   :start    0.744,
                                                   :duration 0.607,
                                                   :offset   0.1}
                                                  {:type   "animation",
                                                   :name   "clap",
                                                   :target "senoraVaca",
                                                   :id     "clap"}
                                                  {:type   "state",
                                                   :name   "syllable",
                                                   :target "syllable",
                                                   :id     "show",
                                                   :params {:text "vas"}}]},
                          :syllable-dor2
                                          {:type "parallel",
                                           :data
                                                 [{:type     "audio",
                                                   :name     "syllable-teacher",
                                                   :id       "syllables",
                                                   :start    6.119,
                                                   :duration 0.615,
                                                   :offset   0.1}
                                                  {:type     "audio",
                                                   :name     "clap-teacher",
                                                   :id       "syllables",
                                                   :start    6.119,
                                                   :duration 0.615,
                                                   :offset   0.1}
                                                  {:type   "animation",
                                                   :name   "clap-teacher",
                                                   :target "senoraVaca",
                                                   :id     "clap"}
                                                  {:type     "audio",
                                                   :name     "syllable-vera",
                                                   :id       "syllables",
                                                   :start    8.798,
                                                   :duration 0.813,
                                                   :offset   0.1}
                                                  {:type     "audio",
                                                   :name     "clap-vera",
                                                   :id       "syllables",
                                                   :start    8.798,
                                                   :duration 0.813,
                                                   :offset   0.1}
                                                  {:type   "animation",
                                                   :name   "clap-vera",
                                                   :target "vera",
                                                   :id     "clap"}
                                                  {:type   "state",
                                                   :name   "syllable",
                                                   :target "syllable",
                                                   :id     "show",
                                                   :params {:text "dor"}}]},
                          :group-cuchara
                                          {:type "sequence",
                                           :name "u-vas syllables",
                                           :data
                                                 ["show-word-cuchara"
                                                  "syllable-cu"
                                                  "syllable-cha"
                                                  "syllable-ra2"
                                                  "empty-1"
                                                  "syllable-cu"
                                                  "syllable-cha"
                                                  "syllable-ra2"
                                                  "empty-1"
                                                  "syllable-cu"
                                                  "syllable-cha"
                                                  "syllable-ra2"
                                                  "empty-1"
                                                  "hide-word"
                                                  "hide-syllable"]},
                          :vera-audio-4
                                          {:type "audio", :id "vera", :start 11.426, :duration 1.253},
                          :vera-audio-5
                                          {:type "audio", :id "vera", :start 14.1, :duration 0.948},
                          :empty-1        {:type "empty", :duration 600},
                          :senora-vaca-audio-10
                                          {:type "audio", :id "teacher", :start 61.686, :duration 6.759},
                          :vera-audio-2
                                          {:type "audio", :id "vera", :start 6.365, :duration 1.405},
                          :senora-vaca-audio-9
                                          {:type "audio", :id "teacher", :start 50.809, :duration 1.409},
                          :senora-vaca-audio-8
                                          {:type "audio", :id "teacher", :start 38.102, :duration 4.739},
                          :vera-audio-6
                                          {:type "audio", :id "vera", :start 16.267, :duration 3.809}},
          :audio
                         {:teacher   "/raw/audio/scripts/intro/teacher.mp3",
                          :vera      "/raw/audio/scripts/intro/vera.mp3",
                          :syllables "/raw/audio/scripts/intro/syllables.mp3"},
          :metadata      {:autostart true}})

(def map-scene {:assets
                                   [{:url  "/raw/audio/background/POL-daily-special-short.mp3",
                                     :size 10,
                                     :type "audio"}
                                    {:url  "/raw/audio/effects/NFF-fruit-collected.mp3",
                                     :size 1,
                                     :type "audio"}
                                    {:url "/raw/audio/effects/NFF-glitter.mp3", :size 1, :type "audio"}
                                    {:url  "/raw/audio/effects/NFF-robo-elastic.mp3",
                                     :size 1,
                                     :type "audio"}
                                    {:url  "/raw/audio/effects/NFF-rusted-thing.mp3",
                                     :size 1,
                                     :type "audio"}
                                    {:url "/raw/audio/effects/NFF-zing.mp3", :size 1, :type "audio"}
                                    {:url "/raw/img/map/background.png", :size 10, :type "image"}
                                    {:url "/raw/img/map/casa_01.png", :size 1, :type "image"}
                                    {:url "/raw/img/map/casa_02.png", :size 1, :type "image"}
                                    {:url "/raw/img/map/feria_01.png", :size 1, :type "image"}
                                    {:url "/raw/img/map/feria_02.png", :size 1, :type "image"}
                                    {:url "/raw/img/map/feria_03.png", :size 1, :type "image"}
                                    {:url "/raw/img/map/feria_locked.png", :size 1, :type "image"}
                                    {:url "/raw/img/ui/back_button_01.png", :size 1, :type "image"}
                                    {:url "/raw/img/ui/back_button_02.png", :size 1, :type "image"}
                                    {:url "/raw/img/ui/close_button_01.png", :size 1, :type "image"}
                                    {:url "/raw/img/ui/close_button_02.png", :size 1, :type "image"}
                                    {:url "/raw/img/ui/play_button_01.png", :size 1, :type "image"}
                                    {:url "/raw/img/ui/play_button_02.png", :size 1, :type "image"}
                                    {:url "/raw/img/ui/reload_button_01.png", :size 1, :type "image"}
                                    {:url "/raw/img/ui/reload_button_02.png", :size 1, :type "image"}
                                    {:url "/raw/img/ui/settings_button_01.png", :size 1, :type "image"}
                                    {:url "/raw/img/ui/settings_button_02.png", :size 1, :type "image"}
                                    {:url "/raw/img/ui/star_01.png", :size 1, :type "image"}
                                    {:url "/raw/img/ui/star_02.png", :size 1, :type "image"}
                                    {:url "/raw/img/ui/star_03.png", :size 1, :type "image"}],
                    :objects
                                   {:background
                                    {:type "background", :src "/raw/img/map/background.png"},
                                    :vera-transition
                                    {:type "transition", :x 1045, :y 540, :object "vera"},
                                    :vera
                                    {:type "image", :src "/raw/img/vera.png", :scale {:x 0.2, :y 0.2}},
                                    :home
                                    {:type   "image",
                                     :x      731,
                                     :y      340,
                                     :width  433,
                                     :height 380,
                                     :src    "/raw/img/map/casa_01.png",
                                     :states
                                             {:default {:type "image", :src "/raw/img/map/casa_01.png"},
                                              :hover   {:type "image", :src "/raw/img/map/casa_02.png"}},
                                     :actions
                                             {:mouseover
                                                     {:type "state", :target "home", :id "hover", :on "mouseover"},
                                              :mouseout
                                                     {:type "state", :target "home", :id "default", :on "mouseout"},
                                              :click {:type "action", :id "move-to-home", :on "click"}}},
                                    :feria
                                    {:type   "image",
                                     :x      235,
                                     :y      683,
                                     :width  319,
                                     :height 280,
                                     :src    "/raw/img/map/feria_01.png",
                                     :states
                                             {:default {:type "image", :src "/raw/img/map/feria_01.png"},
                                              :hover   {:type "image", :src "/raw/img/map/feria_02.png"}},
                                     :actions
                                             {:mouseover
                                                     {:type "state", :target "feria", :id "hover", :on "mouseover"},
                                              :mouseout
                                                     {:type "state", :target "feria", :id "default", :on "mouseout"},
                                              :click {:type "action", :id "move-to-feria", :on "click"}}}},
                    :scene-objects [["background" "home" "feria"] ["vera-transition"]],
                    :actions
                                   {:move-to-feria-transition-1
                                                {:type          "transition",
                                                 :transition-id "vera-transition",
                                                 :to            {:x 915, :y 601}},
                                    :open-home  {:type "scene", :scene-id "home"},
                                    :move-to-feria-transition-4
                                                {:type          "transition",
                                                 :transition-id "vera-transition",
                                                 :to            {:x 850, :y 813}},
                                    :move-to-home-transition
                                                {:type          "transition",
                                                 :transition-id "vera-transition",
                                                 :to            {:x 975, :y 495}},
                                    :open-feria {:type "scene", :scene-id "feria"},
                                    :move-to-feria-transition-2
                                                {:type          "transition",
                                                 :transition-id "vera-transition",
                                                 :to            {:x 950, :y 646}},
                                    :move-to-feria-transition-3
                                                {:type          "transition",
                                                 :transition-id "vera-transition",
                                                 :to            {:x 870, :y 726}},
                                    :move-to-home
                                                {:type "sequence", :data ["move-to-home-transition" "open-home"]},
                                    :move-to-feria-transition-5
                                                {:type          "transition",
                                                 :transition-id "vera-transition",
                                                 :to            {:x 565, :y 835}},
                                    :move-to-feria
                                                {:type "sequence",
                                                 :data
                                                       ["move-to-feria-transition-1"
                                                        "move-to-feria-transition-2"
                                                        "move-to-feria-transition-3"
                                                        "move-to-feria-transition-4"
                                                        "move-to-feria-transition-5"
                                                        "open-feria"]}},
                    :metadata      {:autostart true}})

(def feria-scene {:assets
                                     [{:url  "/raw/audio/background/POL-daily-special-short.mp3",
                                       :size 10,
                                       :type "audio"}
                                      {:url  "/raw/audio/effects/NFF-fruit-collected.mp3",
                                       :size 1,
                                       :type "audio"}
                                      {:url "/raw/audio/effects/NFF-glitter.mp3", :size 1, :type "audio"}
                                      {:url  "/raw/audio/effects/NFF-robo-elastic.mp3",
                                       :size 1,
                                       :type "audio"}
                                      {:url  "/raw/audio/effects/NFF-rusted-thing.mp3",
                                       :size 1,
                                       :type "audio"}
                                      {:url "/raw/audio/effects/NFF-zing.mp3", :size 1, :type "audio"}
                                      {:url "/raw/img/feria/background.png", :size 10, :type "image"}
                                      {:url "/raw/img/feria/back.png", :size 1, :type "image"}
                                      {:url "/raw/img/feria/back_active.png", :size 1, :type "image"}
                                      {:url "/raw/img/feria/wheel.png", :size 2, :type "image"}
                                      {:url "/raw/img/ui/back_button_01.png", :size 1, :type "image"}
                                      {:url "/raw/img/ui/back_button_02.png", :size 1, :type "image"}
                                      {:url "/raw/img/ui/close_button_01.png", :size 1, :type "image"}
                                      {:url "/raw/img/ui/close_button_02.png", :size 1, :type "image"}
                                      {:url "/raw/img/ui/play_button_01.png", :size 1, :type "image"}
                                      {:url "/raw/img/ui/play_button_02.png", :size 1, :type "image"}
                                      {:url "/raw/img/ui/reload_button_01.png", :size 1, :type "image"}
                                      {:url "/raw/img/ui/reload_button_02.png", :size 1, :type "image"}
                                      {:url "/raw/img/ui/settings_button_01.png", :size 1, :type "image"}
                                      {:url "/raw/img/ui/settings_button_02.png", :size 1, :type "image"}
                                      {:url "/raw/img/ui/star_01.png", :size 1, :type "image"}
                                      {:url "/raw/img/ui/star_02.png", :size 1, :type "image"}
                                      {:url "/raw/img/ui/star_03.png", :size 1, :type "image"}],
                      :objects
                                     {:background
                                      {:type "background", :src "/raw/img/feria/background.png"},
                                      :wheel
                                      {:type   "transparent",
                                       :x      467,
                                       :y      105,
                                       :width  708,
                                       :height 778,
                                       :states
                                               {:default {:type "transparent", :src nil},
                                                :hover   {:type "image", :src "/raw/img/feria/wheel.png"}},
                                       :actions
                                               {:mouseover
                                                {:type "state", :target "wheel", :id "hover", :on "mouseover"},
                                                :mouseout
                                                {:type "state", :target "wheel", :id "default", :on "mouseout"}},
                                       :src    nil},
                                      :exit
                                      {:type "image",
                                       :x    1600,
                                       :y    800,
                                       :src  "/raw/img/feria/back.png",
                                       :states
                                             {:default {:src "/raw/img/feria/back.png"},
                                              :hover   {:src "/raw/img/feria/back_active.png"}},
                                       :actions
                                             {:mouseover
                                                     {:type "state", :target "exit", :id "hover", :on "mouseover"},
                                              :mouseout
                                                     {:type "state", :target "exit", :id "default", :on "mouseout"},
                                              :click {:type "scene", :scene-id "map", :on "click"}}},
                                      :vera
                                      {:type  "image",
                                       :x     1100,
                                       :y     650,
                                       :src   "/raw/img/vera.png",
                                       :scale {:x 0.55, :y 0.55}}},
                      :scene-objects [["background" "wheel" "exit"] ["vera"]],
                      :metadata      {:autostart true}})

(defn get-course
  [course-id]
  {:initial-scene "home"
   :preload       ["home", "map", "feria"]})

(defn get-scene
  [couse-id scene-id]
  (case scene-id
    "home" home-scene
    "map" map-scene
    "feria" feria-scene))
