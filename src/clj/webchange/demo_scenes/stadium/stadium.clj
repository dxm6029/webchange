(ns webchange.demo-scenes.stadium.stadium)

(def stadium-scene {:assets [{:url "/raw/img/stadium/main/Stadium_Sketch.jpg", :size 10, :type "image"}
                             ],

                    :objects {:background {:type "background", :src "/raw/img/stadium/main/Stadium_Sketch.jpg"},

                              :volleyball {:type "transparent" :x 683 :y 539 :width 350 :height 500
                                           :actions {:click {:type "scene", :scene-id "volleyball", :on "click"}}}

                              :cycling {:type "transparent" :x 125 :y 539 :width 450 :height 500
                                           :actions {:click {:type "scene", :scene-id "cycling", :on "click"}}}

                              },

                    :scene-objects [["background" "volleyball" "cycling"]],
                    :actions {:start-background-music {:type "audio" :id "background" :loop true}},
                    :audio {:background "/raw/audio/background/POL-daily-special-short.mp3"}
                    :triggers      {:music {:on "start" :action "start-background-music"}}
                    :metadata      {:autostart true
                                    :prev "map"}})
