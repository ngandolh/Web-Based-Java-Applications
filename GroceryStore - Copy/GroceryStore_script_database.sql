USE [master]
GO
/****** Object:  Database [GroceryStore]    Script Date: 3/2/2023 8:16:18 PM ******/
CREATE DATABASE [GroceryStore]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'GroceryStore', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS02\MSSQL\DATA\GroceryStore.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'GroceryStore_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS02\MSSQL\DATA\GroceryStore_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [GroceryStore] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [GroceryStore].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [GroceryStore] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [GroceryStore] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [GroceryStore] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [GroceryStore] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [GroceryStore] SET ARITHABORT OFF 
GO
ALTER DATABASE [GroceryStore] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [GroceryStore] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [GroceryStore] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [GroceryStore] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [GroceryStore] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [GroceryStore] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [GroceryStore] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [GroceryStore] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [GroceryStore] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [GroceryStore] SET  DISABLE_BROKER 
GO
ALTER DATABASE [GroceryStore] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [GroceryStore] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [GroceryStore] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [GroceryStore] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [GroceryStore] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [GroceryStore] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [GroceryStore] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [GroceryStore] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [GroceryStore] SET  MULTI_USER 
GO
ALTER DATABASE [GroceryStore] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [GroceryStore] SET DB_CHAINING OFF 
GO
ALTER DATABASE [GroceryStore] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [GroceryStore] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [GroceryStore] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [GroceryStore] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [GroceryStore] SET QUERY_STORE = OFF
GO
USE [GroceryStore]
GO
/****** Object:  Table [dbo].[Product]    Script Date: 3/2/2023 8:16:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[productId] [int] NOT NULL,
	[title] [varchar](20) NOT NULL,
	[quantity] [int] NOT NULL,
	[price] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[productId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Registration]    Script Date: 3/2/2023 8:16:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Registration](
	[username] [varchar](20) NOT NULL,
	[password] [varchar](20) NOT NULL,
	[lastname] [nvarchar](50) NOT NULL,
	[isAdmin] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Product] ([productId], [title], [quantity], [price]) VALUES (1, N'Canned Beer', 1, 5000)
INSERT [dbo].[Product] ([productId], [title], [quantity], [price]) VALUES (2, N'Newspaper', 1, 2000)
INSERT [dbo].[Product] ([productId], [title], [quantity], [price]) VALUES (3, N'Cleaner', 1, 20000)
INSERT [dbo].[Product] ([productId], [title], [quantity], [price]) VALUES (4, N'Salt', 1, 5000)
INSERT [dbo].[Product] ([productId], [title], [quantity], [price]) VALUES (5, N'Bottled water', 1, 10000)
INSERT [dbo].[Product] ([productId], [title], [quantity], [price]) VALUES (6, N'Ice cream', 1, 15000)
GO
INSERT [dbo].[Registration] ([username], [password], [lastname], [isAdmin]) VALUES (N'anh', N'111555', N'Nguyen', 0)
INSERT [dbo].[Registration] ([username], [password], [lastname], [isAdmin]) VALUES (N'binh', N'2222', N'Tran', 0)
INSERT [dbo].[Registration] ([username], [password], [lastname], [isAdmin]) VALUES (N'hung', N'12345', N'Nguyen', 1)
INSERT [dbo].[Registration] ([username], [password], [lastname], [isAdmin]) VALUES (N'khanh', N'11111', N'Nguyen', 0)
INSERT [dbo].[Registration] ([username], [password], [lastname], [isAdmin]) VALUES (N'minh', N'123', N'Do', 0)
INSERT [dbo].[Registration] ([username], [password], [lastname], [isAdmin]) VALUES (N'vinh', N'9999', N'Le', 0)
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD CHECK  (([price]>=(0)))
GO
ALTER TABLE [dbo].[Registration]  WITH CHECK ADD CHECK  (([isAdmin]=(1) OR [isAdmin]=(0)))
GO
USE [master]
GO
ALTER DATABASE [GroceryStore] SET  READ_WRITE 
GO
