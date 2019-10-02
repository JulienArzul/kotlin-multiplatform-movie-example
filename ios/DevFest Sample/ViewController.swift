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
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        let repository = MovieRepository(movieApiService: MovieApiService())
        repository.discoverMovies(coroutineScope: IosCoroutineScope(mainContext: UI())) { (movieList) in
            print(movieList)
        }
    }


}

