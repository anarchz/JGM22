DROP TABLE IF EXISTS [jgm3].[event]
DROP TABLE IF EXISTS [jgm3].[ticket]
DROP TABLE IF EXISTS [jgm3].[user]
DROP TABLE IF EXISTS [jgm3].[user_account]

CREATE TABLE [jgm3].[event](
	[id] [bigint] NOT NULL IDENTITY PRIMARY KEY,
	[title] [nvarchar] NOT NULL,
	[date] [datetime2](7) NOT NULL,
	[price] [float] NOT NULL,
);

CREATE TABLE [jgm3].[user](
	[id] [bigint] NOT NULL IDENTITY PRIMARY KEY,
	[name] [nvarchar] NOT NULL,
	[email] [nvarchar] NOT NULL,
);

CREATE TABLE [jgm3].[ticket](
	[id] [bigint] NOT NULL IDENTITY PRIMARY KEY,
	[category] [nvarchar] NOT NULL,
	[place] [int](7) NOT NULL,
	[eventId] [bigint] NOT NULL,
	[userId] [bigint] NOT NULL,
);

CREATE TABLE [jgm3].[user_account](
	[money_amount] [float] NOT NULL,
	[userId] [bigint] NOT NULL,
);
GO