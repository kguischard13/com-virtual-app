//
//  AppDelegate.m
//  classroom
//
//  Created by Christopher Forehand on 3/21/14.
//  Copyright (c) 2014 Christopher Forehand. All rights reserved.
//

#import "AppDelegate.h"

@implementation AppDelegate

- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions
{
    self.window = [[UIWindow alloc] initWithFrame:[[UIScreen mainScreen] bounds]];
    
    
    self.loginController = [[LoginViewController alloc] init];
    //self.homeViewController.managedObjectContext = [self managedObjectContext];
	self.navCtrl = [[UINavigationController alloc] initWithRootViewController: self.loginController];
	self.navCtrl.delegate = self.loginController;
    
    
    /*
     self.questionViewController = [[QuestionViewController alloc] init];
     self.navCtrl = [[UINavigationController alloc] initWithRootViewController: self.questionViewController];
     */
    
    /*
    self.noteViewController = [[NoteViewController alloc] init];
	self.navCtrl = [[UINavigationController alloc] initWithRootViewController: self.noteViewController];
	self.navCtrl.delegate = self.noteViewController;
    */
    
    /*
    self.mainMenuController = [[MainMenuController alloc] init];
    self.navCtrl = [[UINavigationController alloc] initWithRootViewController: self.mainMenuController];
    self.navCtrl.delegate = self.mainMenuController;
    */
     
    [self.window setRootViewController: self.navCtrl];
    
    [[UIApplication sharedApplication] setStatusBarHidden: YES];
    
    [self.window makeKeyAndVisible];
    
    
    
    return YES;
}

- (void)applicationWillResignActive:(UIApplication *)application
{
    // Sent when the application is about to move from active to inactive state. This can occur for certain types of temporary interruptions (such as an incoming phone call or SMS message) or when the user quits the application and it begins the transition to the background state.
    // Use this method to pause ongoing tasks, disable timers, and throttle down OpenGL ES frame rates. Games should use this method to pause the game.
}

- (void)applicationDidEnterBackground:(UIApplication *)application
{
    // Use this method to release shared resources, save user data, invalidate timers, and store enough application state information to restore your application to its current state in case it is terminated later. 
    // If your application supports background execution, this method is called instead of applicationWillTerminate: when the user quits.
}

- (void)applicationWillEnterForeground:(UIApplication *)application
{
    // Called as part of the transition from the background to the inactive state; here you can undo many of the changes made on entering the background.
}

- (void)applicationDidBecomeActive:(UIApplication *)application
{
    // Restart any tasks that were paused (or not yet started) while the application was inactive. If the application was previously in the background, optionally refresh the user interface.
}

- (void)applicationWillTerminate:(UIApplication *)application
{
    // Called when the application is about to terminate. Save data if appropriate. See also applicationDidEnterBackground:.
}

@end
