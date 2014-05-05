//
//  Comment.h
//  Test
//
//  Created by Kester Guischard on 4/4/14.
//  Copyright (c) 2014 Kester Guischard. All rights reserved.
//

#import <Foundation/Foundation.h>


@interface Comments : NSObject{
    int Id;
    int QuestionId;
    int UserId;
}

@property int Id;
@property int QuestionId;
@property int UserId;
@property (nonatomic, retain) NSString *Content;
@property (nonatomic, retain) NSDate *DateCreated;

@end
