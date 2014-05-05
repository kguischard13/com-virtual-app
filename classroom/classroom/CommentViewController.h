//
//  CommentViewController.h
//  classroom
//
//  Created by O on 4/29/14.
//  Copyright (c) 2014 Christopher Forehand. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "User.h"
#import "Question.h"
#import "Course.h"

@interface CommentViewController : UIViewController{
    User* currUser;
    Course* selCourse;
    Question* selQuestion;
    id response;
    int numofComment;
}

@property id response;
@property int numofComment;
@property (nonatomic, strong) User *currUser;
@property (nonatomic, strong) Course *selCourse;
@property (nonatomic, strong) Question *selQuestion;


@end
