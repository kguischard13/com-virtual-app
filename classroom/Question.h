//
//  Question.h
//  DataClass
//
//  Created by Kester Guischard on 4/11/14.
//  Copyright (c) 2014 Kester Guischard. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface Question : NSObject{
    int QuestionId;
    int UserId;
    int CourseId;
    int Comments;
    int Likes;
    int QuestionType;
    bool FlagAsInappropriate;
    bool IsPublic;
    bool Anonymous;
}

@property int QuestionId;
@property int UserId;
@property int CourseId;
@property int Comments;
@property int Likes;
@property int QuestionType;
@property bool FlagAsInappropriate;
@property bool IsPublic;
@property bool Anonymous;
@property (nonatomic, retain) NSString *Contents;
@property (nonatomic, retain) NSString *FilePath;
@property (nonatomic, retain) NSDate *DateCreated;
@property (nonatomic, retain) NSMutableArray *CommentsList;




@end
