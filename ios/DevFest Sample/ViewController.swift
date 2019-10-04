//
//  ViewController.swift
//  DevFest Sample
//
//  Created by Julien Arzul on 2/10/19.
//  Copyright © 2019 Julien Arzul. All rights reserved.
//

import UIKit
import common

class ViewController: UIViewController {
    
    @IBOutlet var myLabel: UILabel!
    
    let repository: MovieRepository = {
        guard let baseUrl = Bundle.main.object(forInfoDictionaryKey: "MOVIE_BASE_URL") as? String else {
            fatalError("A Base URL must be set in the Info.plist")
        }
        guard let apiKey = Bundle.main.object(forInfoDictionaryKey: "MOVIE_API_KEY") as? String else {
            fatalError("An API KEY must be set in the Info.plist")
        }
        
        return MovieRepository(movieApiService: MovieApiService(
            baseUrl: baseUrl,
            apiKey: apiKey))
    }()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        repository.discoverMovies(coroutineScope: IosCoroutineScope(mainContext: UI())) { (movieList) in
            print(movieList)
        }
    }
    
    
}

